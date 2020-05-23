package com.example.analyticospring.service;

import com.example.analyticospring.entity.*;
import com.example.analyticospring.json.HashtagRequest;
import com.example.analyticospring.json.PostTweetResponseAnalysis;
import com.example.analyticospring.json.TwitterAnalysisRequest;
import com.example.analyticospring.json.TwitterAnalysisResponse;
import com.example.analyticospring.repository.TwitterRepository;
import com.example.analyticospring.service.implementation.TwitterServiceImpl;
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
public class TwitterService implements TwitterServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TwitterService.class);
    private TwitterRepository twitterRepository;
    private TweetService tweetService;
    private TweetHashtagService tweetHashtagService;

    @Value("${analytico.flask}")
    private String flaskurl;

    @Autowired
    public void setTwitterRepository(TwitterRepository twitterRepository) {
        this.twitterRepository = twitterRepository;
    }

    @Autowired
    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Autowired
    public void setTweetHashtagService(TweetHashtagService tweetHashtagService) {
        this.tweetHashtagService = tweetHashtagService;
    }

    public Twitter addTwitterInstance(String screen_name, User user, Analyzer analyzer) {
        Twitter twitter = new Twitter();
        twitter.setScreen_name(screen_name);
        twitter.setFollowers(0);
        twitter.setFollowing(0);
        twitter.setAnalysis(false);
        twitter.setDate(new Date());
        twitter.setUser(user);
        twitter.setAnalyzer(analyzer);
        try {
            twitter = twitterRepository.save(twitter);
            logger.info("{} twitter detail successfully saved in to database", user.getEmailId());
            return twitter;
        } catch (DataAccessException error) {
            logger.error("Error while saving the twitter data for user {}, {}", user.getEmailId(), error.getLocalizedMessage());
        }
        return null;
    }

    public Twitter getById(Integer twitter_id) {
        return twitterRepository.findById(twitter_id).orElse(null);
    }


    public Twitter updateFollowerCount(Twitter twitter, Integer followers, Integer following, String email) {
        twitter.setFollowers(followers);
        twitter.setFollowing(following);
        try {
            twitter = twitterRepository.save(twitter);
            logger.info("{} followers and following count on twitter detail successfully saved in to database", email);
            return twitter;
        } catch (DataAccessException error) {
            logger.error("Error while saving the followers and following count on twitter data for user {}, {}", email,
                    error.getLocalizedMessage());
        }
        return null;
    }

    public void updateAnalysisCompletion(Twitter twitter, String email) {
        twitter.setAnalysis(true);
        try {
            twitterRepository.save(twitter);
            logger.info("{} analysis complete for twitter {}, all tweets and hashtags stored in database", email,
                    twitter.getId());
        } catch (DataAccessException error) {
            logger.error("Error while setting analysis completion for {} twitter {}, {}", email, twitter.getId(),
                    error.getLocalizedMessage());
        }
    }

    public void callForAnalysis(TwitterAnalysisRequest twitterAnalysisRequest) {
        WebClient webClient = WebClient.builder().baseUrl(flaskurl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        Mono<TwitterAnalysisResponse> twitterAnalysisResponseMono = webClient.post().uri("/twitter_analysis")
                .body(Mono.just(twitterAnalysisRequest), TwitterAnalysisRequest.class).retrieve()
                .bodyToMono(TwitterAnalysisResponse.class);
        twitterAnalysisResponseMono.subscribe(this::getTwitterAnalysisAndProcess);
    }

    public void getTwitterAnalysisAndProcess(TwitterAnalysisResponse twitterAnalysisResponse) {
        Twitter twitter = getById(twitterAnalysisResponse.getTwitter());
        if (twitter == null) {
            logger.debug("Failed to get twitter id for user {}, twitter id not found",
                    twitterAnalysisResponse.getEmail());
            return;
        }

        twitter = updateFollowerCount(twitter, twitterAnalysisResponse.getFollowers(),
                twitterAnalysisResponse.getFollowing(), twitterAnalysisResponse.getEmail());
        if (twitter == null) {
            return;
        }

        for (PostTweetResponseAnalysis tweet : twitterAnalysisResponse.getTweets()) {
            Tweet tweet1 = tweetService.addTweetInstance(tweet.getScreen_name(), tweet.getLink(), tweet.getPost(),
                    tweet.getSentimental(), tweet.getNews(), tweet.getQuestion(), tweet.getHashtag_count(),
                    true, twitter);

            if(tweet1 == null ){
                continue;
            }
            for (HashtagRequest hashtag : tweet.getHashtags()) {
                tweetHashtagService.addTweetHashtagInstance(hashtag.getName(), tweet1);
            }
        }

        for (PostTweetResponseAnalysis hashtags : twitterAnalysisResponse.getHashtags()) {
            Tweet tweet1 = tweetService.addTweetInstance(hashtags.getScreen_name(), hashtags.getLink(),
                    hashtags.getPost(), hashtags.getSentimental(), hashtags.getNews(), hashtags.getQuestion(),
                    hashtags.getHashtag_count(), false, twitter);
            if(tweet1 == null ){
                continue;
            }
            for (HashtagRequest hashtag : hashtags.getHashtags()) {
                tweetHashtagService.addTweetHashtagInstance(hashtag.getName(), tweet1);
            }
        }

        updateAnalysisCompletion(twitter, twitterAnalysisResponse.getEmail());

    }
}
