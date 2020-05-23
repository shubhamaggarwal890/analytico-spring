package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.FacebookPosts;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.FacebookAnalysisResponse;
import com.example.analyticospring.json.FacebookRequest;
import com.example.analyticospring.json.HashtagRequest;
import com.example.analyticospring.json.PostTweetResponseAnalysis;
import com.example.analyticospring.repository.FacebookRepository;
import com.example.analyticospring.service.implementation.FacebookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@Slf4j
public class FacebookService implements FacebookServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(FacebookService.class);
    private FacebookRepository facebookRepository;
    private FacebookPostService facebookPostService;
    private FacebookHashtagService facebookHashtagService;

    @Value("${analytico.flask}")
    private String flaskurl;


    @Autowired
    public void setFacebookRepository(FacebookRepository facebookRepository) {
        this.facebookRepository = facebookRepository;
    }

    @Autowired
    public void setFacebookPostService(FacebookPostService facebookPostService) {
        this.facebookPostService = facebookPostService;
    }

    @Autowired
    public void setFacebookHashtagService(FacebookHashtagService facebookHashtagService) {
        this.facebookHashtagService = facebookHashtagService;
    }

    public Facebook addFacebookInstance(String email, String name, String page, User user, Analyzer analyzer) {
        Facebook facebook = new Facebook();
        facebook.setEmail(email);
        facebook.setName(name);
        facebook.setPage(page);
        facebook.setFriends(0);
        facebook.setAnalysis(false);
        facebook.setDate(new Date());
        facebook.setUser(user);
        facebook.setAnalyzer(analyzer);
        try {
            facebook = facebookRepository.save(facebook);
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


    public Facebook updateFriendsCount(Facebook facebook, Integer friends, String email) {
        facebook.setFriends(friends);
        try {
            facebook = facebookRepository.save(facebook);
            logger.info("{} friends count on facebook detail successfully saved in to database", email);
            return facebook;
        } catch (DataAccessException error) {
            logger.error("Error while saving the friends count on facebook data for user {}, {}", email,
                    error.getLocalizedMessage());
        }
        return null;
    }

    public void updateAnalysisCompletion(Facebook facebook, String email) {
        facebook.setAnalysis(true);
        try {
            facebookRepository.save(facebook);
            logger.info("{} analysis complete for facebook {}, all posts and hashtags stored in database", email,
                    facebook.getId());
        } catch (DataAccessException error) {
            logger.error("Error while setting analysis completion for {} facebook {}, {}", email, facebook.getId(),
                    error.getLocalizedMessage());
        }
    }

    public void callForAnalysis(FacebookRequest facebookRequest) {
        WebClient webClient = WebClient.builder().baseUrl(flaskurl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        Mono<FacebookAnalysisResponse> facebookAnalysisResponseMono = webClient.post().uri("/facebook_analysis")
                .body(Mono.just(facebookRequest), FacebookRequest.class).retrieve()
                .bodyToMono(FacebookAnalysisResponse.class);
        facebookAnalysisResponseMono.subscribe(this::getFacebookAnalysisAndProcess);
    }

    public void getFacebookAnalysisAndProcess(FacebookAnalysisResponse facebookAnalysisResponse) {
        Facebook facebook = getById(facebookAnalysisResponse.getFacebook());
        if (facebook == null) {
            logger.debug("Failed to get facebook id for user {}, facebook id not found",
                    facebookAnalysisResponse.getEmail());
            return;
        }

        facebook = updateFriendsCount(facebook, facebookAnalysisResponse.getFriends(),
                facebookAnalysisResponse.getEmail());
        if (facebook == null) {
            return;
        }

        for (PostTweetResponseAnalysis post : facebookAnalysisResponse.getPosts()) {
            FacebookPosts facebookPosts = facebookPostService.addPostInstance(post.getPost(), post.getSentimental(),
                    post.getQuestion(), post.getHashtag_count(), facebook);

            for (HashtagRequest hashtag : post.getHashtags()) {
                facebookHashtagService.addFacebookHashtag(hashtag.getName(), facebookPosts);
            }
        }
        updateAnalysisCompletion(facebook, facebookAnalysisResponse.getEmail());
    }


}
