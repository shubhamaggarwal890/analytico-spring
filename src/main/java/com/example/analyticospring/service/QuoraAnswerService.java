package com.example.analyticospring.service;

import com.example.analyticospring.entity.QuoraAnswers;
import com.example.analyticospring.entity.QuoraQuestion;
import com.example.analyticospring.repository.QuoraAnswerRepository;
import com.example.analyticospring.service.implementation.QuoraAnswerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuoraAnswerService implements QuoraAnswerServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(QuoraAnswerService.class);
    private QuoraAnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(QuoraAnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public QuoraAnswers addAnswerInstance(String author, String answer, Double sentimental, QuoraQuestion question) {
        QuoraAnswers answers = new QuoraAnswers();
        answers.setAuthor(author);
        answers.setAnswer(answer);
        answers.setSentimental(sentimental);
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
