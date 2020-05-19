package com.example.analyticospring.controller;

import com.example.analyticospring.entity.User;
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
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        logger.info("POST request /signup {} signing up", user.getEmailId());
        User user1 = userService.signup(user.getFirstName(), user.getLastName(), user.getEmailId(), user.getPassword());
        if (user1 == null) {
            logger.debug("{} signup attempt failed, service returned null", user.getEmailId());
            return ResponseEntity.ok().build();
        }
        user1.setSalt(null);
        user1.setPassword(null);
        logger.debug("{} signup attempt successful, {} created successfully", user1.getEmailId(), user1.getEmailId());
        return ResponseEntity.ok().body(user1);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        logger.info("POST request /login {} signing in", user.getEmailId());
        User user1 = userService.signin(user.getEmailId(), user.getPassword());
        if (user1 == null) {
            logger.debug("{} login attempt failed, service returned null", user.getEmailId());
            return ResponseEntity.ok().build();
        }
        user1.setSalt(null);
        user1.setPassword(null);
        logger.info("{} login attempt successful", user1.getEmailId());
        return ResponseEntity.ok().body(user1);
    }

}
