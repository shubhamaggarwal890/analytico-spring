package com.example.analyticospring.service;

import com.example.analyticospring.entity.*;
import com.example.analyticospring.repository.QuestionRepository;
import com.example.analyticospring.service.implementation.QuestionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuestionService implements QuestionServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);
    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question addQuestionInstance(String question, String question_url, boolean from_question, Quora quora) {
        Question question1 = new Question();
        question1.setQuestion(question);
        question1.setQuestion_url(question_url);
        question1.setFrom_question(from_question);
        question1.setQuora(quora);
        try {
            question1 = questionRepository.save(question1);
            logger.info("question of quora {} successfully saved in to database", quora.getId());
            return question1;

        } catch (DataAccessException error) {
            logger.error("Error while saving the question of {}, {}", quora.getId(), error.getLocalizedMessage());
        }
        return null;
    }
}
