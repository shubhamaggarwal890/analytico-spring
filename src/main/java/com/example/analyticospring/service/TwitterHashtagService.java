package com.example.analyticospring.service;

import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.TwitterHashtag;
import com.example.analyticospring.repository.TwitterHashtagRepository;
import com.example.analyticospring.service.implementation.TwitterHashtagServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TwitterHashtagService implements TwitterHashtagServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TwitterHashtagService.class);
    private TwitterHashtagRepository twitterHashtagRepository;

    @Autowired
    public void setTwitterHashtagRepository(TwitterHashtagRepository twitterHashtagRepository) {
        this.twitterHashtagRepository = twitterHashtagRepository;
    }

    public TwitterHashtag addTwitterHashtag(String hashtag, boolean analysis, Tweet tweet, Twitter twitter) {
        TwitterHashtag twitterHashtag = new TwitterHashtag();
        twitterHashtag.setName(hashtag);
        twitterHashtag.setAnalysis(analysis);
        twitterHashtag.setTweet(tweet);
        twitterHashtag.setTwitter(twitter);
        try {
            twitterHashtag = twitterHashtagRepository.save(twitterHashtag);
            logger.info("{} twitter hashtag detail successfully saved in to database for twitter {}", hashtag, twitter.getId());
            return twitterHashtag;
        } catch (DataAccessException error) {
            logger.error("Error while saving the twitter hashtag {} for twitter {}, {}", hashtag, twitter.getId(),
                    error.getLocalizedMessage());
        }
        return null;
    }
}
