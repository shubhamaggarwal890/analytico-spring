package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.repository.AnalyzerRepository;
import com.example.analyticospring.service.implementation.AnalyzerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnalyzerService implements AnalyzerServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(AnalyzerService.class);
    private AnalyzerRepository analyzerRepository;

    @Autowired
    public void setAnalyzerRepository(AnalyzerRepository analyzerRepository) {
        this.analyzerRepository = analyzerRepository;
    }

    public Analyzer addAnalyzerInstance(Analyzer analyzer, String email, String use) {
        Analyzer analyzer1 = new Analyzer();
        analyzer1.setSentimental(analyzer.isSentimental());
        analyzer1.setNews(analyzer.isNews());
        analyzer1.setQuestion(analyzer.isQuestion());
        analyzer1.setFollowers(analyzer.isFollowers());
        analyzer1.setHashtags(analyzer.isHashtags());
        try {
            analyzer1 = analyzerRepository.save(analyzer1);
            logger.info("{} analyzer details for {} successfully saved in to database", email, use);
            return analyzer1;
        } catch (DataAccessException error) {
            logger.error("Error while saving the analyzer data for {} user {}, {}", use, email,
                    error.getLocalizedMessage());
        }
        return null;

    }
}
