package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.repository.FacebookRepository;
import com.example.analyticospring.service.implementation.FacebookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class FacebookService implements FacebookServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(FacebookService.class);
    private FacebookRepository facebookRepository;

    @Autowired
    public void setFacebookRepository(FacebookRepository facebookRepository) {
        this.facebookRepository = facebookRepository;
    }

    public Facebook addFacebookInstance(String email, String name, String page, User user, Analyzer analyzer) {
        Facebook facebook = new Facebook();
        facebook.setEmail(email);
        facebook.setName(name);
        facebook.setPage(page);
        facebook.setFriends_count(null);
        facebook.setDate(new Date());
        facebook.setUser(user);
        facebook.setAnalyzer(analyzer);
        try {
            facebookRepository.save(facebook);
            logger.info("{} facebook detail successfully saved in to database", user.getEmailId());
            return facebook;
        } catch (DataAccessException error) {
            logger.error("Error while saving the facebook data for user {}, {}", user.getEmailId(), error.getLocalizedMessage());
        }
        return null;
    }

    public Facebook getById(Integer facebook_id) {
        return facebookRepository.findById(facebook_id).orElse(null);
    }


}
