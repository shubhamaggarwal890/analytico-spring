package com.example.analyticospring.service;

import com.example.analyticospring.entity.Answers;
import com.example.analyticospring.entity.Question;
import com.example.analyticospring.repository.AnswerRepository;
import com.example.analyticospring.service.implementation.AnswerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnswerService implements AnswerServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(AnswerService.class);
    private AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answers addAnswerInstance(String answerer, String answer_url, String answer, String sentimental,
                                     Question question) {
        Answers answers = new Answers();
        answers.setAnswerer(answerer);
        answers.setAnswer_url(answer_url);
        answers.setAnswer(answer);
        answers.setSentimental_remarks(sentimental);
        answers.setQuestion(question);
        try {
            answers = answerRepository.save(answers);
            logger.info("answer of quora question {} successfully saved in to database", question.getId());
            return answers;

        } catch (DataAccessException error) {
            logger.error("Error while saving the answer of question {}, {}", question.getId(), error.getLocalizedMessage());
        }
        return null;
    }

}
