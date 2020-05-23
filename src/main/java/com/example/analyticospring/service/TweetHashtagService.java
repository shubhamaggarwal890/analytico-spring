package com.example.analyticospring.service;

import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.TweetHashtag;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.repository.TweetHashtagRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TweetHashtagService {
    private static final Logger logger = LoggerFactory.getLogger(TweetHashtagService.class);
    private TweetHashtagRepository tweetHashtagRepository;

    @Autowired
    public void setTweetHashtagRepository(TweetHashtagRepository tweetHashtagRepository) {
        this.tweetHashtagRepository = tweetHashtagRepository;
    }

    public TweetHashtag addTweetHashtagInstance(String hashtag, Tweet tweet, Twitter twitter) {
        TweetHashtag tweetHashtag = new TweetHashtag();
        tweetHashtag.setName(hashtag);
        tweetHashtag.setTweet(tweet);
        tweetHashtag.setTwitter(twitter);
        try {
            tweetHashtag = tweetHashtagRepository.save(tweetHashtag);
            logger.info("{} tweet hashtag detail successfully saved in to database for tweet {}", hashtag, tweet.getId());
            return tweetHashtag;
        } catch (DataAccessException error) {
            logger.error("Error while saving the tweet hashtag {} for tweet {}, {}", hashtag, tweet.getId(),
                    error.getLocalizedMessage());
        }
        return null;

    }

    public List<Object[]> getTopHashtagsForTwitter(Twitter twitter) {
        return tweetHashtagRepository.findTweetHashtagByTweet(twitter);
    }
}
