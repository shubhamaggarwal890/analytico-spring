package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.FacebookPosts;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.*;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
                    post.getQuestion(), post.getHashtag_count(), false, facebook);

            if (facebookPosts == null) {
                continue;
            }

            for (HashtagRequest hashtag : post.getHashtags()) {
                facebookHashtagService.addFacebookHashtag(hashtag.getName(), facebookPosts, facebook);
            }
        }

        for (PostTweetResponseAnalysis post : facebookAnalysisResponse.getPage_post()) {
            FacebookPosts facebookPosts = facebookPostService.addPostInstance(post.getPost(), post.getSentimental(),
                    post.getQuestion(), post.getHashtag_count(), true, facebook);
            if (facebookPosts == null) {
                continue;
            }
            for (HashtagRequest hashtag : post.getHashtags()) {
                facebookHashtagService.addFacebookHashtag(hashtag.getName(), facebookPosts, facebook);
            }
        }

        updateAnalysisCompletion(facebook, facebookAnalysisResponse.getEmail());
    }

    public List<Object> getFacebookByUser(User user) {
        List<Facebook> facebook = facebookRepository.findFacebookByUser(user);
        if (facebook.isEmpty()) {
            logger.info("User {} not started any facebook analysis, looking for reports", user.getEmailId());
            return Arrays.asList(null, "You haven't started any analysis of your facebook data, Kindly start one");
        }
        if (facebook.get(0).isAnalysis()) {
            logger.info("User {} sending facebook {} analysis", user.getEmailId(), facebook.get(0).getId());
            return Arrays.asList(facebook.get(0), null);
        }
        if (facebook.size() == 1 && !facebook.get(0).isAnalysis()) {
            logger.info("User {} facebook {} analysis is under being analyzed, looking for reports", user.getEmailId(),
                    facebook.get(0).getId());
            return Arrays.asList(null, "Your facebook data is being analyzed. Kindly wait or Comeback later");
        }
        if (facebook.size() > 1 && facebook.get(1).isAnalysis()) {
            logger.info("User {} facebook {} analysis is under being analyzed, sending previous reports", user.getEmailId(),
                    facebook.get(0).getId());
            return Arrays.asList(facebook.get(1), "Your latest facebook data in being analyzed, " +
                    "Here's report from your previous analysis");
        } else {
            logger.error("User {} last analysis for facebook was incomplete, some error occurred", user.getEmailId());
            return Arrays.asList(null, "Your facebook data is being analyzed. Kindly wait or Comeback later");
        }
    }

    public FAnalysisChart prepareAnalysisFacebook(Facebook facebook) {
        FAnalysisChart analysisChart = new FAnalysisChart();
        analysisChart.setFriends(facebook.getFriends());
        analysisChart.setUser(facebook.getName());
        List<FacebookPosts> posts = facebookPostService.getPostsByFacebook(facebook);
        analysisChart.setPost_count(posts.size());
        int hashtags = 0;
        List<Object[]> objects = facebookHashtagService.getTopHashtagsForFacebook(facebook);
        List<HashtagAnalysisChart> hashtags_a = new ArrayList<>();
        for (Object[] topHashtags : objects) {
            HashtagAnalysisChart hashtagAnalysisChart = new HashtagAnalysisChart();
            hashtagAnalysisChart.setName(String.valueOf(topHashtags[0]));
            hashtagAnalysisChart.setNumber(Integer.valueOf(String.valueOf(topHashtags[1])));
            hashtags_a.add(hashtagAnalysisChart);
        }
        analysisChart.setHashtags(hashtags_a);
        int s_positive = 0;
        int s_neutral = 0;
        int s_negative = 0;
        int q_true = 0;
        int q_false = 0;
        int from_page = 0;
        int not_page = 0;
        int h_s_positive = 0;
        int h_s_neutral = 0;
        int h_s_negative = 0;
        int h_q_true = 0;
        int h_q_false = 0;

        for (FacebookPosts facebookPosts : posts) {
            hashtags += facebookPosts.getHashtags();
            if (facebookPosts.isFrom_page()) {
                from_page++;
                if (facebookPosts.getSentimental() != null) {
                    if (facebookPosts.getSentimental() >= 0.65) {
                        h_s_positive++;
                    } else if (facebookPosts.getSentimental() < 0.65 && facebookPosts.getSentimental() >= 0.30) {
                        h_s_neutral++;
                    } else {
                        h_s_negative++;
                    }
                }
                if (facebookPosts.getQuestion() != null) {
                    if (facebookPosts.getQuestion() >= 0.30) {
                        h_q_true++;
                    } else {
                        h_q_false++;
                    }
                }
            } else {
                not_page++;
                if (facebookPosts.getSentimental() != null) {
                    if (facebookPosts.getSentimental() >= 0.65) {
                        s_positive++;
                    } else if (facebookPosts.getSentimental() < 0.65 && facebookPosts.getSentimental() >= 0.30) {
                        s_neutral++;
                    } else {
                        s_negative++;
                    }
                }
                if (facebookPosts.getQuestion() != null) {
                    if (facebookPosts.getQuestion() >= 0.30) {
                        q_true++;
                    } else {
                        q_false++;
                    }
                }
            }
        }
        analysisChart.setS_positive((int) (((double) s_positive / (double) not_page) * 100));
        analysisChart.setS_neutral((int) (((double) s_neutral / (double) not_page) * 100));
        analysisChart.setS_negative((int) (((double) s_negative / (double) not_page) * 100));
        analysisChart.setQ_true((int) (((double) q_true / (double) not_page) * 100));
        analysisChart.setQ_false((int) (((double) q_false / (double) not_page) * 100));
        analysisChart.setHashtags_count(hashtags);
        THashtagModelChart hashtagModelChart = new THashtagModelChart();

        if(facebook.getPage()!=null){
            hashtagModelChart.setName(facebook.getPage());
            hashtagModelChart.setS_positive((int) (((double) h_s_positive / (double) from_page) * 100));
            hashtagModelChart.setS_neutral((int) (((double) h_s_neutral / (double) from_page) * 100));
            hashtagModelChart.setS_negative((int) (((double) h_s_negative / (double) from_page) * 100));
            hashtagModelChart.setQ_true((int) (((double) h_q_true / (double) from_page) * 100));
            hashtagModelChart.setQ_false((int) (((double) h_q_false / (double) from_page) * 100));
            analysisChart.setH_model(hashtagModelChart);
        }else{
            analysisChart.setH_model(null);
        }

        return analysisChart;
    }


}
