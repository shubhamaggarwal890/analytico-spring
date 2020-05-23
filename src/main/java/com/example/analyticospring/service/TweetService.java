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

    public Tweet addTweetInstance(String screen_name, String link, String tweet, Double sentimental, Double news,
                                  Double question, Integer hashtags, boolean from_screen_name, Twitter twitter){
        Tweet tweet1 = new Tweet();
        tweet1.setScreen_name(screen_name);
        tweet1.setLink(link);
        tweet1.setTweet(tweet);
        tweet1.setSentimental(sentimental);
        tweet1.setNews(news);
        tweet1.setQuestion(question);
        tweet1.setHashtags(hashtags);
        tweet1.setFrom_screen_name(from_screen_name);
        tweet1.setTwitter(twitter);
        try {
            tweet1 = tweetRepository.save(tweet1);
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
