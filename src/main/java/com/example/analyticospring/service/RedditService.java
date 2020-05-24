package com.example.analyticospring.service;

import com.example.analyticospring.entity.*;
import com.example.analyticospring.json.*;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
                        comment.getSentimental(), comment.getControversial(), comment.getUps(), redditPosts, reddit);
            }
        }

        updateAnalysisCompletion(reddit, redditAnalysisResponse.getEmail());
    }

    public List<Object> getRedditByUser(User user) {
        List<Reddit> reddit = redditRepository.findRedditByUser(user);
        if (reddit.isEmpty()) {
            logger.info("User {} not started any reddit analysis, looking for reports", user.getEmailId());
            return Arrays.asList(null, "You haven't started any analysis of your reddit data, Kindly start one");
        }
        if (reddit.get(0).isAnalysis()) {
            logger.info("User {} sending reddit {} analysis", user.getEmailId(), reddit.get(0).getId());
            return Arrays.asList(reddit.get(0), null);
        }
        if (reddit.size() == 1 && !reddit.get(0).isAnalysis()) {
            logger.info("User {} reddit {} analysis is under being analyzed, looking for reports", user.getEmailId(),
                    reddit.get(0).getId());
            return Arrays.asList(null, "Your reddit data is being analyzed. Kindly wait or Comeback later");
        }
        if (reddit.size() > 1 && reddit.get(1).isAnalysis()) {
            logger.info("User {} reddit {} analysis is under being analyzed, sending previous reports", user.getEmailId(),
                    reddit.get(0).getId());
            return Arrays.asList(reddit.get(1), "Your latest reddit data in being analyzed, " +
                    "Here's report from your previous analysis");
        } else {
            logger.error("User {} last analysis for reddit was incomplete, some error occurred", user.getEmailId());
            return Arrays.asList(null, "Your reddit data is being analyzed. Kindly wait or Comeback later");
        }
    }

    public RAnalysisChart prepareAnalysisReddit(Reddit reddit) {
        RAnalysisChart analysisChart = new RAnalysisChart();
        analysisChart.setSubreddit(reddit.getSubreddit());

        List<RedditPosts> posts = redditPostsService.getPostsByReddit(reddit);
        List<RedditComments> comments = redditCommentService.getPostCommentsByReddit(reddit);
        analysisChart.setPost_count(posts.size());
        analysisChart.setComments_count(comments.size());
        int updowns = 0;
        List<Object[]> objects = redditPostsService.getTopPostsByUpsReddit(reddit);
        List<HashtagAnalysisChart> hashtags_a = new ArrayList<>();
        for (Object[] topHashtags : objects) {
            HashtagAnalysisChart hashtagAnalysisChart = new HashtagAnalysisChart();
            hashtagAnalysisChart.setName(String.valueOf(topHashtags[0]));
            hashtagAnalysisChart.setNumber(Integer.valueOf(String.valueOf(topHashtags[1])));
            hashtags_a.add(hashtagAnalysisChart);
        }
        analysisChart.setUps(hashtags_a);
        int s_positive = 0;
        int s_neutral = 0;
        int s_negative = 0;
        int h_s_positive = 0;
        int h_s_neutral = 0;
        int h_s_negative = 0;
        int h_c_positive = 0;
        int h_c_negative = 0;

        for(RedditPosts redditPosts: posts){
            updowns += redditPosts.getUps();
            if (redditPosts.getSentimental() != null) {
                if (redditPosts.getSentimental() >= 0.65) {
                    s_positive++;
                } else if (redditPosts.getSentimental() < 0.65 && redditPosts.getSentimental() >= 0.30) {
                    s_neutral++;
                } else {
                    s_negative++;
                }
            }
        }
        analysisChart.setS_positive((int) (((double) s_positive / (double) posts.size()) * 100));
        analysisChart.setS_neutral((int) (((double) s_neutral / (double) posts.size()) * 100));
        analysisChart.setS_negative((int) (((double) s_negative / (double) posts.size()) * 100));


        RCommentChart rCommentChart = new RCommentChart();

        for(RedditComments redditComments: comments){
            updowns += redditComments.getUps();
            if (redditComments.getSentimental() != null) {
                if (redditComments.getSentimental() >= 0.65) {
                    h_s_positive++;
                } else if (redditComments.getSentimental() < 0.65 && redditComments.getSentimental() >= 0.30) {
                    h_s_neutral++;
                } else {
                    h_s_negative++;
                }
                if (redditComments.getControversy() > 0) {
                    h_c_positive++;
                } else {
                    h_c_negative++;
                }
            }
        }
        analysisChart.setUpdowns(updowns);
        if(comments.isEmpty()){
            analysisChart.setComments(null);
        }else{
            List<Object[]> objects1 = redditCommentService.getTopCommentsByUpsReddit(reddit);
            List<HashtagAnalysisChart> comments_a = new ArrayList<>();
            for (Object[] topHashtags : objects1) {
                HashtagAnalysisChart hashtagAnalysisChart = new HashtagAnalysisChart();
                hashtagAnalysisChart.setName(String.valueOf(topHashtags[0]));
                hashtagAnalysisChart.setNumber(Integer.valueOf(String.valueOf(topHashtags[1])));
                comments_a.add(hashtagAnalysisChart);
            }
            rCommentChart.setUps(comments_a);
            rCommentChart.setS_positive((int) (((double) h_s_positive / (double) comments.size()) * 100));
            rCommentChart.setS_neutral((int) (((double) h_s_neutral / (double) comments.size()) * 100));
            rCommentChart.setS_negative((int) (((double) h_s_negative / (double) comments.size()) * 100));
            rCommentChart.setC_positive((int) (((double) h_c_positive / (double) comments.size()) * 100));
            rCommentChart.setC_negative((int) (((double) h_c_negative / (double) comments.size()) * 100));
            analysisChart.setComments(rCommentChart);
        }
        return analysisChart;
    }
}
