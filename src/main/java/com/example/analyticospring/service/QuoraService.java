package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Quora;
import com.example.analyticospring.entity.QuoraQuestion;
import com.example.analyticospring.entity.User;
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

import java.util.Date;

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
            quoraAnswerService.addAnswerInstance(query.getAuthor(), query.getAnswer(), query.getSentimental(),
                    quoraQuestion);
        }
        QuestionQuoraAnalysis question = quoraAnalysisResponse.getQuestion();
        QuoraQuestion quoraQuestion = quoraQuestionService.addQuestionInstance(question.getQuestion(),
                question.getAnswer_count(), question.getLink(), true, quora);
        for (AnswerQuoraAnalysis answer : question.getAnswers()) {
            quoraAnswerService.addAnswerInstance(answer.getAuthor(), answer.getAnswer(), answer.getSentimental(),
                    quoraQuestion);
        }

        updateAnalysisCompletion(quora, quoraAnalysisResponse.getEmail());
    }


}
