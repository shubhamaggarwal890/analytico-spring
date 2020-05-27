package com.example.analyticospring.controller;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Quora;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.QAnalysisChart;
import com.example.analyticospring.json.QuoraRequest;
import com.example.analyticospring.json.RAnalysisChart;
import com.example.analyticospring.json.RedditRequest;
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

import java.util.List;

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
        QuoraRequest quoraRequest1 = new QuoraRequest();
        quoraRequest1.setUser_id(quora.getId());
        quoraRequest1.setEmail(user.getEmailId());
        quoraRequest1.setQuery(quoraRequest.getQuery());
        quoraRequest1.setQuestion(quoraRequest.getQuestion());
        quoraRequest1.setAnalyzer(quoraRequest.getAnalyzer());
        quoraService.callForAnalysis(quoraRequest1);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/get_quora_analysis")
    public ResponseEntity<QAnalysisChart> getQuoraAnalysis(@RequestBody QuoraRequest quoraRequest) {
        User user = userService.getById(quoraRequest.getUser_id());
        if (user == null) {
            logger.debug("POST request /get_quora_analysis {} user not found in database", quoraRequest.getUser_id());
            return ResponseEntity.notFound().build();
        }

        logger.info("POST request /get_quora_analysis for user {}", user.getEmailId());
        List<Object> quoraAnalyze = quoraService.getQuoraByUser(user);
        QAnalysisChart analysisChart = new QAnalysisChart();

        if (quoraAnalyze.get(0) == null && quoraAnalyze.get(1) != null) {
            analysisChart.setMessage((String) quoraAnalyze.get(1));
            return ResponseEntity.ok().body(analysisChart);
        } else if (quoraAnalyze.get(0) != null && quoraAnalyze.get(1) == null) {
            analysisChart = quoraService.prepareAnalysisQuora((Quora) quoraAnalyze.get(0));
            analysisChart.setMessage(null);
            return ResponseEntity.ok().body(analysisChart);
        } else {
            analysisChart = quoraService.prepareAnalysisQuora((Quora) quoraAnalyze.get(0));
            analysisChart.setMessage((String) quoraAnalyze.get(1));
            return ResponseEntity.ok().body(analysisChart);
        }
    }
}
