package com.example.analyticospring.service;

import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.repository.TweetRepository;
import com.example.analyticospring.service.implementation.TweetServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TweetService implements TweetServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TweetService.class);
    private TweetRepository tweetRepository;

    @Autowired
    public void setTweetRepository(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public Tweet addTweetInstance(String screen_name, String screen_name_url, String tweet, String sentimental_remark,
                                  String news_remark, String question_remark, Twitter twitter) {
        Tweet tweet1 = new Tweet();
        tweet1.setScreen_name(screen_name);
        tweet1.setScreen_name_url(screen_name_url);
        tweet1.setTweet(tweet);
        tweet1.setSentimental_remark(sentimental_remark);
        tweet1.setNews_remark(news_remark);
        tweet1.setQuestion_remark(question_remark);
        tweet1.setTwitter(twitter);
        try {
            tweetRepository.save(tweet1);
            logger.info("tweet of {} successfully saved along with analysis in to database for twitter {}", screen_name,
                    twitter.getId());
            return tweet1;
        } catch (DataAccessException error) {
            logger.error("Error while saving the tweet of {} for twitter {}, {}", screen_name, twitter.getId(),
                    error.getLocalizedMessage());
        }
        return null;
    }
}
