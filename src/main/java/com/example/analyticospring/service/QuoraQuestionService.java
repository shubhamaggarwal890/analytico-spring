package com.example.analyticospring.service;

import com.example.analyticospring.entity.*;
import com.example.analyticospring.repository.QuoraQuestionRepository;
import com.example.analyticospring.service.implementation.QuoraQuestionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuoraQuestionService implements QuoraQuestionServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(QuoraQuestionService.class);
    private QuoraQuestionRepository quoraQuestionRepository;

    @Autowired
    public void setQuoraQuestionRepository(QuoraQuestionRepository quoraQuestionRepository) {
        this.quoraQuestionRepository = quoraQuestionRepository;
    }

    public QuoraQuestion addQuestionInstance(String question, Integer answers, String link, boolean from_question,
                                             Quora quora) {
        QuoraQuestion question1 = new QuoraQuestion();
        question1.setQuestion(question.substring(0, Math.min(question.length(), 500)));
        question1.setAnswers(answers);
        question1.setLink(link);
        question1.setFrom_question(from_question);
        question1.setQuora(quora);
        try {
            question1 = quoraQuestionRepository.save(question1);
            logger.info("question of quora {} successfully saved in to database", quora.getId());
            return question1;

        } catch (DataAccessException error) {
            logger.error("Error while saving the question of {}, {}", quora.getId(), error.getLocalizedMessage());
        }
        return null;
    }
}
