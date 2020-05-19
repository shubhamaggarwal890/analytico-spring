package com.example.analyticospring.controller;

import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.json.TwitterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TwitterController {
    @PostMapping("/twitter_analysis")
    public ResponseEntity<Twitter> startTwitterAnalysis(@RequestBody TwitterRequest twitter){
        return null;
    }

}
