package com.example.analyticospring.controller;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.TwitterHashtag;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.HashtagRequest;
import com.example.analyticospring.json.TwitterAnalysisRequest;
import com.example.analyticospring.json.TwitterRequest;
import com.example.analyticospring.service.AnalyzerService;
import com.example.analyticospring.service.TwitterHashtagService;
import com.example.analyticospring.service.TwitterService;
import com.example.analyticospring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class TwitterController {
    private static final Logger logger = LoggerFactory.getLogger(TwitterController.class);
    private UserService userService;
    private TwitterService twitterService;
    private AnalyzerService analyzerService;
    private TwitterHashtagService twitterHashtagService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTwitterService(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @Autowired
    public void setAnalyzerService(AnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    @Autowired
    public void setTwitterHashtagService(TwitterHashtagService twitterHashtagService) {
        this.twitterHashtagService = twitterHashtagService;
    }

    @PostMapping("/twitter_analysis")
    public ResponseEntity<Twitter> startTwitterAnalysis(@RequestBody TwitterRequest twitter) {
        User user = userService.getById(twitter.getUser_id());
        if (user == null) {
            logger.debug("POST request /twitter_analysis {} user not found in database", twitter.getUser_id());
            return ResponseEntity.notFound().build();
        }
        logger.info("POST request /twitter_analysis for user {}", user.getEmailId());
        Analyzer analyzer = analyzerService.addAnalyzerInstance(twitter.getAnalyzer(), user.getEmailId(), "twitter");
        if (analyzer == null) {
            logger.debug("Failed to store {} analyzer data for twitter, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }
        Twitter twitter1 = twitterService.addTwitterInstance(twitter.getScreen_name(), user, analyzer);
        if (twitter1 == null) {
            logger.debug("Failed to store {} twitter analysis data, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }
        for (HashtagRequest hashtagRequest : twitter.getHashtags()) {
            TwitterHashtag twitterHashtag = twitterHashtagService.addTwitterHashtag(hashtagRequest.getName(), twitter1);
            if (twitterHashtag == null) {
                logger.debug("Failed to store {} twitter hashtag {} for analysis, service returned null",
                        user.getEmailId(), hashtagRequest.getName());
                return ResponseEntity.notFound().build();
            }
        }
        TwitterAnalysisRequest twitterAnalysisRequest = new TwitterAnalysisRequest();
        twitterAnalysisRequest.setScreen_name(twitter.getScreen_name());
        twitterAnalysisRequest.setTwitter_id(twitter1.getId());
        twitterAnalysisRequest.setHashtags(twitter.getHashtags());
        twitterAnalysisRequest.setAnalyzer(twitter.getAnalyzer());
        twitterAnalysisRequest.setEmail(user.getEmailId());
        twitterService.callForAnalysis(twitterAnalysisRequest);
        return ResponseEntity.ok().build();
    }
}
