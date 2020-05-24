package com.example.analyticospring.service;

import com.example.analyticospring.entity.*;
import com.example.analyticospring.json.*;
import com.example.analyticospring.repository.QuoraRepository;
import com.example.analyticospring.service.implementation.QuoraServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class QuoraService implements QuoraServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(QuoraService.class);
    private QuoraRepository quoraRepository;
    private QuoraQuestionService quoraQuestionService;
    private QuoraAnswerService quoraAnswerService;

    @Value("${analytico.flask}")
    private String flaskurl;

    @Autowired
    public void setQuoraRepository(QuoraRepository quoraRepository) {
        this.quoraRepository = quoraRepository;
    }

    @Autowired
    public void setQuoraQuestionService(QuoraQuestionService quoraQuestionService) {
        this.quoraQuestionService = quoraQuestionService;
    }

    @Autowired
    public void setQuoraAnswerService(QuoraAnswerService quoraAnswerService) {
        this.quoraAnswerService = quoraAnswerService;
    }

    public Quora addQuoraInstance(String query, String question, User user, Analyzer analyzer) {
        Quora quora = new Quora();
        quora.setSearch_query(query);
        quora.setQuestion(question);
        quora.setAnalysis(false);
        quora.setDate(new Date());
        quora.setUser(user);
        quora.setAnalyzer(analyzer);
        try {
            quora = quoraRepository.save(quora);
            logger.info("{} quora detail successfully saved in to database", user.getEmailId());
            return quora;
        } catch (DataAccessException error) {
            logger.error("Error while saving the quora data for user {}, {}", user.getEmailId(), error.getLocalizedMessage());
        }
        return null;
    }

    public Quora getById(Integer quora_id) {
        return quoraRepository.findById(quora_id).orElse(null);
    }

    public void updateAnalysisCompletion(Quora quora, String email) {
        quora.setAnalysis(true);
        try {
            quoraRepository.save(quora);
            logger.info("{} analysis complete for quora {}, all questions and answers stored in database", email,
                    quora.getId());
        } catch (DataAccessException error) {
            logger.error("Error while setting analysis completion for {} quora {}, {}", email, quora.getId(),
                    error.getLocalizedMessage());
        }
    }

    public void callForAnalysis(QuoraRequest quoraRequest) {
        WebClient webClient = WebClient.builder().baseUrl(flaskurl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        Mono<QuoraAnalysisResponse> quoraAnalysisResponseMono = webClient.post().uri("/quora_analysis")
                .body(Mono.just(quoraRequest), QuoraRequest.class).retrieve()
                .bodyToMono(QuoraAnalysisResponse.class);
        quoraAnalysisResponseMono.subscribe(this::getQuoraAnalysisAndProcess);
    }

    public void getQuoraAnalysisAndProcess(QuoraAnalysisResponse quoraAnalysisResponse) {
        Quora quora = getById(quoraAnalysisResponse.getQuora());
        if (quora == null) {
            logger.debug("Failed to get quora id for user {}, quora id not found", quoraAnalysisResponse.getEmail());
            return;
        }

        for (QueryQuoraAnalysis query : quoraAnalysisResponse.getQuery()) {
            QuoraQuestion quoraQuestion = quoraQuestionService.addQuestionInstance(query.getQuestion(),
                    query.getAnswer_count(), query.getLink(), false, quora);
            if (quoraQuestion == null) {
                continue;
            }
            quoraAnswerService.addAnswerInstance(query.getAuthor(), query.getAnswer(), query.getSentimental(),
                    quoraQuestion, quora);
        }
        QuestionQuoraAnalysis question = quoraAnalysisResponse.getQuestion();
        if (question != null) {
            QuoraQuestion quoraQuestion = quoraQuestionService.addQuestionInstance(question.getQuestion(),
                    question.getAnswer_count(), question.getLink(), true, quora);

            if (quoraQuestion != null) {
                for (AnswerQuoraAnalysis answer : question.getAnswers()) {
                    quoraAnswerService.addAnswerInstance(answer.getAuthor(), answer.getAnswer(), answer.getSentimental(),
                            quoraQuestion, quora);
                }

            }
        }
        updateAnalysisCompletion(quora, quoraAnalysisResponse.getEmail());
    }

    public List<Object> getQuoraByUser(User user) {
        List<Quora> quora = quoraRepository.findQuoraByUser(user);
        if (quora.isEmpty()) {
            logger.info("User {} not started any quora analysis, looking for reports", user.getEmailId());
            return Arrays.asList(null, "You haven't started any analysis of your quora data, Kindly start one");
        }
        if (quora.get(0).isAnalysis()) {
            logger.info("User {} sending quora {} analysis", user.getEmailId(), quora.get(0).getId());
            return Arrays.asList(quora.get(0), null);
        }
        if (quora.size() == 1 && !quora.get(0).isAnalysis()) {
            logger.info("User {} quora {} analysis is under being analyzed, looking for reports", user.getEmailId(),
                    quora.get(0).getId());
            return Arrays.asList(null, "Your quora data is being analyzed. Kindly wait or Comeback later");
        }
        if (quora.size() > 1 && quora.get(1).isAnalysis()) {
            logger.info("User {} quora {} analysis is under being analyzed, sending previous reports", user.getEmailId(),
                    quora.get(0).getId());
            return Arrays.asList(quora.get(1), "Your latest quora data in being analyzed, " +
                    "Here's report from your previous analysis");
        } else {
            logger.error("User {} last analysis for quora was incomplete, some error occurred", user.getEmailId());
            return Arrays.asList(null, "Your quora data is being analyzed. Kindly wait or Comeback later");
        }
    }

    public QAnalysisChart prepareAnalysisQuora(Quora quora) {
        QAnalysisChart analysisChart = new QAnalysisChart();
        analysisChart.setQuery(quora.getSearch_query());
        analysisChart.setQuestion(quora.getQuestion());

        List<QuoraQuestion> questions = quoraQuestionService.getQuoraQuestionsByQuora(quora);
        analysisChart.setQuestion_count(questions.size());
        List<QuoraAnswers> answers = quoraAnswerService.getQuoraAnswersByQuora(quora);
        analysisChart.setAnswer_count(answers.size());

        List<Object[]> objects = quoraQuestionService.getTopMaxAnswersByQuora(quora);
        List<HashtagAnalysisChart> hashtags_a = new ArrayList<>();
        for (Object[] topHashtags : objects) {
            HashtagAnalysisChart hashtagAnalysisChart = new HashtagAnalysisChart();
            hashtagAnalysisChart.setName(String.valueOf(topHashtags[0]).substring(0, 10) + "...");
            hashtagAnalysisChart.setNumber(Integer.valueOf(String.valueOf(topHashtags[1])));
            hashtags_a.add(hashtagAnalysisChart);
        }
        analysisChart.setAnswers(hashtags_a);

        int s_positive = 0;
        int s_neutral = 0;
        int s_negative = 0;
        int h_s_positive = 0;
        int h_s_neutral = 0;
        int h_s_negative = 0;

        for (QuoraAnswers quoraAnswers : answers) {
            if (quoraAnswers.getSentimental() != null) {
                if (quoraAnswers.getSentimental() >= 0.65) {
                    s_positive++;
                } else if (quoraAnswers.getSentimental() < 0.65 && quoraAnswers.getSentimental() >= 0.30) {
                    s_neutral++;
                } else {
                    s_negative++;
                }
            }

            analysisChart.setS_positive((int) (((double) s_positive / (double) answers.size()) * 100));
            analysisChart.setS_neutral((int) (((double) s_neutral / (double) answers.size()) * 100));
            analysisChart.setS_negative((int) (((double) s_negative / (double) answers.size()) * 100));
        }
        List<QuoraAnswers> answers1 = new ArrayList<>();
        for (QuoraQuestion question : questions) {
            if (question.isFrom_question()) {
                answers1 = quoraAnswerService.getQuoraAnswersByQuestion(question);
                break;
            }
        }
        if (!answers1.isEmpty()) {
            for (QuoraAnswers quoraAnswers : answers1) {
                if (quoraAnswers.getSentimental() != null) {
                    if (quoraAnswers.getSentimental() >= 0.65) {
                        h_s_positive++;
                    } else if (quoraAnswers.getSentimental() < 0.65 && quoraAnswers.getSentimental() >= 0.30) {
                        h_s_neutral++;
                    } else {
                        h_s_negative++;
                    }
                }
            }
            analysisChart.setQ_s_positive((int) (((double) h_s_positive / (double) answers1.size()) * 100));
            analysisChart.setQ_s_neutral((int) (((double) h_s_neutral / (double) answers1.size()) * 100));
            analysisChart.setQ_s_negative((int) (((double) h_s_negative / (double) answers1.size()) * 100));
        } else {
            analysisChart.setQ_s_positive(0);
            analysisChart.setQ_s_neutral(0);
            analysisChart.setQ_s_negative(0);
        }


        return analysisChart;
    }


}
