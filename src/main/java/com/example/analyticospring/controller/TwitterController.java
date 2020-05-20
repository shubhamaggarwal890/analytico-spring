package com.example.analyticospring.controller;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.TwitterRequest;
import com.example.analyticospring.service.AnalyzerService;
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
    private UserService userService;
    private TwitterService twitterService;
    private AnalyzerService analyzerService;
    private static final Logger logger = LoggerFactory.getLogger(TwitterController.class);

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

    @PostMapping("/twitter_analysis")
    public ResponseEntity<Twitter> startTwitterAnalysis(@RequestBody TwitterRequest twitter){
        User user = userService.getById(twitter.getUser_id());
        if(user == null){
            logger.debug("POST request /twitter_analysis {} user not found in database", twitter.getUser_id());
            return ResponseEntity.ok().build();
        }
        logger.info("POST request /twitter_analysis for user {}", user.getEmailId());
        Analyzer analyzer = analyzerService.addAnalyzerInstance(twitter.getAnalyzer(), user.getEmailId(), "twitter");
        if(analyzer == null){
            logger.debug("Failed to store {} analyzer data for twitter, service returned null", user.getEmailId());
            return ResponseEntity.ok().build();
        }
        Twitter twitter1 = twitterService.addTwitterInstance(twitter.getScreen_name(), user, analyzer);
        if(twitter1 == null){
            logger.debug("Failed to store {} twitter analysis data, service returned null", user.getEmailId());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.ok().body(twitter1);
    }

}
