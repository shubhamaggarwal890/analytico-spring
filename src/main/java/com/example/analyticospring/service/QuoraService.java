package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Quora;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.repository.QuoraRepository;
import com.example.analyticospring.service.implementation.QuoraServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class QuoraService implements QuoraServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(QuoraService.class);
    private QuoraRepository quoraRepository;

    @Autowired
    public void setQuoraRepository(QuoraRepository quoraRepository) {
        this.quoraRepository = quoraRepository;
    }

    public Quora addQuoraInstance(String query, String question, User user, Analyzer analyzer) {
        Quora quora = new Quora();
        quora.setSearch_query(query);
        quora.setQuestion(question);
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

}
