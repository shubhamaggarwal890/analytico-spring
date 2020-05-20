package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.repository.RedditRepository;
import com.example.analyticospring.service.implementation.RedditServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class RedditService implements RedditServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(RedditService.class);
    private RedditRepository redditRepository;

    @Autowired
    public void setRedditRepository(RedditRepository redditRepository) {
        this.redditRepository = redditRepository;
    }

    public Reddit addRedditInstance(String subreddit, User user, Analyzer analyzer) {
        Reddit reddit = new Reddit();
        reddit.setSubreddit(subreddit);
        reddit.setDate(new Date());
        reddit.setUser(user);
        reddit.setAnalyzer(analyzer);
        try {
            reddit = redditRepository.save(reddit);
            logger.info("{} reddit detail successfully saved in to database", user.getEmailId());
            return reddit;
        } catch (DataAccessException error) {
            logger.error("Error while saving the reddit data for user {}, {}", user.getEmailId(), error.getLocalizedMessage());
        }
        return null;
    }

    public Reddit getById(Integer reddit_id) {
        return redditRepository.findById(reddit_id).orElse(null);
    }

}
