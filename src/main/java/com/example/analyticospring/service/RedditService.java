package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.RedditPosts;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.CommentRedditAnalysis;
import com.example.analyticospring.json.PostRedditAnalysis;
import com.example.analyticospring.json.RedditAnalysisResponse;
import com.example.analyticospring.json.RedditRequest;
import com.example.analyticospring.repository.RedditRepository;
import com.example.analyticospring.service.implementation.RedditServiceImpl;
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
public class RedditService implements RedditServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(RedditService.class);
    private RedditRepository redditRepository;
    private RedditPostsService redditPostsService;
    private RedditCommentService redditCommentService;

    @Value("${analytico.flask}")
    private String flaskurl;

    @Autowired
    public void setRedditRepository(RedditRepository redditRepository) {
        this.redditRepository = redditRepository;
    }

    @Autowired
    public void setRedditPostsService(RedditPostsService redditPostsService) {
        this.redditPostsService = redditPostsService;
    }

    @Autowired
    public void setRedditCommentService(RedditCommentService redditCommentService) {
        this.redditCommentService = redditCommentService;
    }

    public Reddit addRedditInstance(String subreddit, User user, Analyzer analyzer) {
        Reddit reddit = new Reddit();
        reddit.setSubreddit(subreddit);
        reddit.setDate(new Date());
        reddit.setUser(user);
        reddit.setAnalyzer(analyzer);
        try {
            reddit = redditRepository.save(reddit);
            logger.info("{} reddit detail successfully saved in to database", user.getEmailId());
            return reddit;
        } catch (DataAccessException error) {
            logger.error("Error while saving the reddit data for user {}, {}", user.getEmailId(), error.getLocalizedMessage());
        }
        return null;
    }

    public Reddit getById(Integer reddit_id) {
        return redditRepository.findById(reddit_id).orElse(null);
    }

    public void updateAnalysisCompletion(Reddit reddit, String email) {
        reddit.setAnalysis(true);
        try {
            redditRepository.save(reddit);
            logger.info("{} analysis complete for reddit {}, all posts and comments stored in database", email,
                    reddit.getId());
        } catch (DataAccessException error) {
            logger.error("Error while setting analysis completion for {} reddit {}, {}", email, reddit.getId(),
                    error.getLocalizedMessage());
        }
    }

    public void callForAnalysis(RedditRequest redditRequest) {
        WebClient webClient = WebClient.builder().baseUrl(flaskurl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        Mono<RedditAnalysisResponse> redditAnalysisResponseMono = webClient.post().uri("/reddit_analysis")
                .body(Mono.just(redditRequest), RedditRequest.class).retrieve()
                .bodyToMono(RedditAnalysisResponse.class);
        redditAnalysisResponseMono.subscribe(this::getRedditAnalysisAndProcess);
    }

    public void getRedditAnalysisAndProcess(RedditAnalysisResponse redditAnalysisResponse) {
        Reddit reddit = getById(redditAnalysisResponse.getReddit());
        if (reddit == null) {
            logger.debug("Failed to get reddit id for user {}, reddit id not found",
                    redditAnalysisResponse.getEmail());
            return;
        }
        for (PostRedditAnalysis posts : redditAnalysisResponse.getPosts()) {
            RedditPosts redditPosts = redditPostsService.addRedditPostsInstance(posts.getAuthor(), posts.getLink(),
                    posts.getUps(), posts.getPost(), posts.getSentimental(), posts.getComments_count(), reddit);
            if(redditPosts == null){
                continue;
            }
            for (CommentRedditAnalysis comment : posts.getComments()) {
                redditCommentService.addCommentInstance(comment.getAuthor(), comment.getComment(),
                        comment.getSentimental(), comment.getControversial(), comment.getUps(), redditPosts);
            }
        }

        updateAnalysisCompletion(reddit, redditAnalysisResponse.getEmail());
    }


}
