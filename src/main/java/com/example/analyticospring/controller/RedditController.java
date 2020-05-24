package com.example.analyticospring.controller;

import com.example.analyticospring.entity.*;
import com.example.analyticospring.json.*;
import com.example.analyticospring.service.AnalyzerService;
import com.example.analyticospring.service.RedditService;
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

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class RedditController {
    private static final Logger logger = LoggerFactory.getLogger(RedditController.class);
    private UserService userService;
    private AnalyzerService analyzerService;
    private RedditService redditService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAnalyzerService(AnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    @Autowired
    public void setRedditService(RedditService redditService) {
        this.redditService = redditService;
    }

    @PostMapping("/reddit_analysis")
    public ResponseEntity<Reddit> startRedditAnalysis(@RequestBody RedditRequest redditRequest) {
        User user = userService.getById(redditRequest.getUser_id());
        if (user == null) {
            logger.debug("POST request /reddit_analysis {} user not found in database", redditRequest.getUser_id());
            return ResponseEntity.notFound().build();
        }
        logger.info("POST request /reddit_analysis for user {}", user.getEmailId());
        Analyzer analyzer = analyzerService.addAnalyzerInstance(redditRequest.getAnalyzer(), user.getEmailId(), "reddit");
        if (analyzer == null) {
            logger.debug("Failed to store {} analyzer data for reddit, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }
        Reddit reddit = redditService.addRedditInstance(redditRequest.getSubreddit(), user, analyzer);
        if (reddit == null) {
            logger.debug("Failed to store {} reddit analysis data, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }
        RedditRequest redditRequest1 = new RedditRequest();
        redditRequest1.setEmail(user.getEmailId());
        redditRequest1.setUser_id(reddit.getId());
        redditRequest1.setSubreddit(redditRequest.getSubreddit());
        redditRequest1.setAnalyzer(redditRequest.getAnalyzer());

        redditService.callForAnalysis(redditRequest1);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/get_reddit_analysis")
    public ResponseEntity<RAnalysisChart> getTwitterAnalysis(@RequestBody RedditRequest redditRequest) {

        User user = userService.getById(redditRequest.getUser_id());
        if (user == null) {
            logger.debug("POST request /get_reddit_analysis {} user not found in database", redditRequest.getUser_id());
            return ResponseEntity.notFound().build();
        }

        logger.info("POST request /get_reddit_analysis for user {}", user.getEmailId());
        List<Object> redditAnalyze = redditService.getRedditByUser(user);
        RAnalysisChart analysisChart = new RAnalysisChart();

        if (redditAnalyze.get(0) == null && redditAnalyze.get(1) != null) {
            analysisChart.setMessage((String) redditAnalyze.get(1));
            return ResponseEntity.ok().body(analysisChart);
        } else if (redditAnalyze.get(0) != null && redditAnalyze.get(1) == null) {
            analysisChart = redditService.prepareAnalysisReddit((Reddit) redditAnalyze.get(0));
            analysisChart.setMessage(null);
            return ResponseEntity.ok().body(analysisChart);
        } else {
            analysisChart = redditService.prepareAnalysisReddit((Reddit) redditAnalyze.get(0));
            analysisChart.setMessage((String) redditAnalyze.get(1));
            return ResponseEntity.ok().body(analysisChart);
        }
    }


}
