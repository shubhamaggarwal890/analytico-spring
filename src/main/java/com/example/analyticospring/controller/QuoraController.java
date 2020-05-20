package com.example.analyticospring.controller;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Quora;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.QuoraRequest;
import com.example.analyticospring.service.AnalyzerService;
import com.example.analyticospring.service.QuoraService;
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
public class QuoraController {
    private static final Logger logger = LoggerFactory.getLogger(QuoraController.class);
    private UserService userService;
    private AnalyzerService analyzerService;
    private QuoraService quoraService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAnalyzerService(AnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    @Autowired
    public void setQuoraService(QuoraService quoraService) {
        this.quoraService = quoraService;
    }

    @PostMapping("/quora_analysis")
    public ResponseEntity<Quora> startQuoraAnalysis(@RequestBody QuoraRequest quoraRequest) {
        User user = userService.getById(quoraRequest.getUser_id());
        if (user == null) {
            logger.debug("POST request /quora_analysis {} user not found in database", quoraRequest.getUser_id());
            return ResponseEntity.notFound().build();
        }
        logger.info("POST request /quora_analysis for user {}", user.getEmailId());
        Analyzer analyzer = analyzerService.addAnalyzerInstance(quoraRequest.getAnalyzer(), user.getEmailId(), "quora");
        if (analyzer == null) {
            logger.debug("Failed to store {} analyzer data for quora, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }
        Quora quora = quoraService.addQuoraInstance(quoraRequest.getQuery(), quoraRequest.getQuestion(), user, analyzer);
        if (quora == null) {
            logger.debug("Failed to store {} quora analysis data, service returned null", user.getEmailId());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();

    }

}
