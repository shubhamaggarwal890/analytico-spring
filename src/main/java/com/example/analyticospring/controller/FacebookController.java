package com.example.analyticospring.controller;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.FacebookRequest;
import com.example.analyticospring.service.AnalyzerService;
import com.example.analyticospring.service.FacebookService;
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
public class FacebookController {
    private static final Logger logger = LoggerFactory.getLogger(FacebookController.class);
    private UserService userService;
    private FacebookService facebookService;
    private AnalyzerService analyzerService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setFacebookService(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    @Autowired
    public void setAnalyzerService(AnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    @PostMapping("/facebook_analysis")
    public ResponseEntity<Facebook> startFacebookAnalysis(@RequestBody FacebookRequest facebook) {
        User user = userService.getById(facebook.getUser_id());
        if (user == null) {
            logger.debug("POST request /facebook_analysis {} user not found in database", facebook.getUser_id());
            return ResponseEntity.notFound().build();
        }
        logger.info("POST request /facebook_analysis for user {}", user.getEmailId());
        Analyzer analyzer = analyzerService.addAnalyzerInstance(facebook.getAnalyzer(), user.getEmailId(), "facebook");
        if (analyzer == null) {
            logger.debug("Failed to store {} analyzer data for facebook, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }
        Facebook facebook1 = facebookService.addFacebookInstance(facebook.getEmail(), facebook.getName(),
                facebook.getPage(), user, analyzer);

        if (facebook1 == null) {
            logger.debug("Failed to store {} facebook analysis data, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}
