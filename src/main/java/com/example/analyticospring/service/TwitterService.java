package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.repository.TwitterRepository;
import com.example.analyticospring.service.implementation.TwitterServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class TwitterService implements TwitterServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TwitterService.class);
    private TwitterRepository twitterRepository;

    @Autowired
    public void setTwitterRepository(TwitterRepository twitterRepository) {
        this.twitterRepository = twitterRepository;
    }

    public Twitter addTwitterInstance(String screen_name, User user, Analyzer analyzer) {
        Twitter twitter = new Twitter();
        twitter.setScreen_name(screen_name);
        twitter.setFollowers_count(0);
        twitter.setDate(new Date());
        twitter.setUser(user);
        twitter.setAnalyzer(analyzer);
        try {
            twitter = twitterRepository.save(twitter);
            logger.info("{} twitter detail successfully saved in to database", user.getEmailId());
            return twitter;
        } catch (DataAccessException error) {
            logger.error("Error while saving the twitter data for user {}, {}", user.getEmailId(), error.getLocalizedMessage());
        }
        return null;
    }

    public Twitter getById(Integer twitter_id) {
        return twitterRepository.findById(twitter_id).orElse(null);
    }
}
