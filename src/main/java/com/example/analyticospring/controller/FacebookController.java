package com.example.analyticospring.controller;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.FAnalysisChart;
import com.example.analyticospring.json.FacebookRequest;
import com.example.analyticospring.json.TAnalysisChart;
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

import java.util.List;

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

        FacebookRequest facebookRequest = new FacebookRequest();
        facebookRequest.setUser_id(facebook1.getId());
        facebookRequest.setEmail(user.getEmailId());
        facebookRequest.setName(facebook.getName());
        facebookRequest.setPage(facebook.getPage());
        facebookRequest.setToken(facebook.getToken());
        facebookRequest.setAnalyzer(facebook.getAnalyzer());
        facebookService.callForAnalysis(facebookRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/get_facebook_analysis")
    public ResponseEntity<FAnalysisChart> getFacebookAnalysis(@RequestBody FacebookRequest facebookRequest) {
        User user = userService.getById(facebookRequest.getUser_id());
        if (user == null) {
            logger.debug("POST request /get_facebook_analysis {} user not found in database", facebookRequest.getUser_id());
            return ResponseEntity.notFound().build();
        }

        logger.info("POST request /get_facebook_analysis for user {}", user.getEmailId());
        List<Object> facebookAnalyze = facebookService.getFacebookByUser(user);
        FAnalysisChart analysisChart = new FAnalysisChart();

        if (facebookAnalyze.get(0) == null && facebookAnalyze.get(1) != null) {
            analysisChart.setMessage((String) facebookAnalyze.get(1));
            return ResponseEntity.ok().body(analysisChart);
        } else if (facebookAnalyze.get(0) != null && facebookAnalyze.get(1) == null) {
            analysisChart = facebookService.prepareAnalysisFacebook((Facebook) facebookAnalyze.get(0));
            analysisChart.setMessage(null);
            return ResponseEntity.ok().body(analysisChart);
        } else {
            analysisChart = facebookService.prepareAnalysisFacebook((Facebook) facebookAnalyze.get(0));
            analysisChart.setMessage((String) facebookAnalyze.get(1));
            return ResponseEntity.ok().body(analysisChart);
        }
    }
}
