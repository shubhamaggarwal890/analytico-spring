package com.example.analyticospring.service;

import com.example.analyticospring.entity.Analyzer;
import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.User;
import com.example.analyticospring.json.*;
import com.example.analyticospring.repository.TwitterRepository;
import com.example.analyticospring.service.implementation.TopHashtags;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TwitterService implements TwitterServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TwitterService.class);
    private TwitterRepository twitterRepository;
    private TweetService tweetService;
    private TweetHashtagService tweetHashtagService;
    private TwitterHashtagService twitterHashtagService;

    @Value("${analytico.flask}")
    private String flaskurl;

    @Autowired
    public void setTwitterRepository(TwitterRepository twitterRepository) {
        this.twitterRepository = twitterRepository;
    }

    @Autowired
    public void setTwitterHashtagService(TwitterHashtagService twitterHashtagService) {
        this.twitterHashtagService = twitterHashtagService;
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

    public List<Object> getTwitterByUser(User user) {
        List<Twitter> twitters = twitterRepository.findTwitterByUser(user);
        if (twitters.isEmpty()) {
            logger.info("User {} not started any twitter analysis, looking for reports", user.getEmailId());
            return Arrays.asList(null, "You haven't started any analysis of your twitter data, Kindly start one");
        }
        if (twitters.get(0).isAnalysis()) {
            logger.info("User {} sending twitter {} analysis", user.getEmailId(), twitters.get(0).getId());
            return Arrays.asList(twitters.get(0), null);
        }
        if (twitters.size() == 1 && !twitters.get(0).isAnalysis()) {
            logger.info("User {} twitter {} analysis is under being analyzed, looking for reports", user.getEmailId(),
                    twitters.get(0).getId());
            return Arrays.asList(null, "Your twitter data is being analyzed. Kindly wait or Comeback later");
        }
        if (twitters.size() > 1 && twitters.get(1).isAnalysis()) {
            logger.info("User {} twitter {} analysis is under being analyzed, sending previous reports", user.getEmailId(),
                    twitters.get(0).getId());
            return Arrays.asList(twitters.get(1), "Your latest twitter data in being analyzed, " +
                    "Here's report from your previous analysis");
        } else {
            logger.error("User {} last analysis for twitter was incomplete, some error occurred", user.getEmailId());
            return Arrays.asList(null, "Your twitter data is being analyzed. Kindly wait or Comeback later");
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

            if (tweet1 == null) {
                continue;
            }
            for (HashtagRequest hashtag : tweet.getHashtags()) {
                tweetHashtagService.addTweetHashtagInstance(hashtag.getName(), tweet1, twitter);
            }
        }

        for (PostTweetResponseAnalysis hashtags : twitterAnalysisResponse.getHashtags()) {
            Tweet tweet1 = tweetService.addTweetInstance(hashtags.getScreen_name(), hashtags.getLink(),
                    hashtags.getPost(), hashtags.getSentimental(), hashtags.getNews(), hashtags.getQuestion(),
                    hashtags.getHashtag_count(), false, twitter);
            if (tweet1 == null) {
                continue;
            }
            for (HashtagRequest hashtag : hashtags.getHashtags()) {
                tweetHashtagService.addTweetHashtagInstance(hashtag.getName(), tweet1, twitter);
            }
        }

        updateAnalysisCompletion(twitter, twitterAnalysisResponse.getEmail());

    }

    public TAnalysisChart prepareAnalysisTwitter(Twitter twitter) {
        TAnalysisChart analysisChart = new TAnalysisChart();
        analysisChart.setFollowers(twitter.getFollowers());
        analysisChart.setFollowing(twitter.getFollowing());
        analysisChart.setScreen_name(twitter.getScreen_name());
        List<Tweet> tweets = tweetService.getTweetsByTwitter(twitter);
        analysisChart.setTweets_count(tweets.size());
        int hashtags = 0;
        List<Object[]> objects = tweetHashtagService.getTopHashtagsForTwitter(twitter);
        System.out.println(Arrays.toString(objects.get(0)));
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
        int n_false = 0;
        int n_true = 0;
        int q_true = 0;
        int q_false = 0;
        int from_screen_name = 0;
        int not_screen_name = 0;
        int h_s_positive = 0;
        int h_s_neutral = 0;
        int h_s_negative = 0;
        int h_n_false = 0;
        int h_n_true = 0;
        int h_q_true = 0;
        int h_q_false = 0;

        for (Tweet tweet : tweets) {
            if (tweet.isFrom_screen_name()) {
                from_screen_name++;
                if (tweet.getSentimental() != null) {
                    if (tweet.getSentimental() >= 0.65) {
                        s_positive++;
                    } else if (tweet.getSentimental() < 0.65 && tweet.getSentimental() >= 0.30) {
                        s_neutral++;
                    } else {
                        s_negative++;
                    }
                }
                if (tweet.getQuestion() != null) {
                    if (tweet.getQuestion() >= 0.30) {
                        q_true++;
                    } else {
                        q_false++;
                    }
                }
                if (tweet.getNews() != null) {
                    if (tweet.getNews() >= 0.55) {
                        n_true++;
                    } else {
                        n_false++;
                    }
                }
            } else {
                not_screen_name++;
                if (tweet.getSentimental() != null) {
                    if (tweet.getSentimental() >= 0.65) {
                        h_s_positive++;
                    } else if (tweet.getSentimental() < 0.65 && tweet.getSentimental() >= 0.30) {
                        h_s_neutral++;
                    } else {
                        h_s_negative++;
                    }
                }
                if (tweet.getQuestion() != null) {
                    if (tweet.getQuestion() >= 0.30) {
                        h_q_true++;
                    } else {
                        h_q_false++;
                    }
                }
                if (tweet.getNews() != null) {
                    if (tweet.getNews() >= 0.55) {
                        h_n_true++;
                    } else {
                        h_n_false++;
                    }
                }
            }
            hashtags += tweet.getHashtags();
        }
        analysisChart.setS_positive((int) (((double) s_positive / (double) from_screen_name) * 100));
        analysisChart.setS_neutral((int) (((double) s_neutral / (double) from_screen_name) * 100));
        analysisChart.setS_negative((int) (((double) s_negative / (double) from_screen_name) * 100));
        analysisChart.setQ_true((int) (((double) q_true / (double) from_screen_name) * 100));
        analysisChart.setQ_false((int) (((double) q_false / (double) from_screen_name) * 100));
        analysisChart.setN_true((int) (((double) n_true / (double) from_screen_name) * 100));
        analysisChart.setN_fake((int) (((double) n_false / (double) from_screen_name) * 100));
        analysisChart.setHashtags_count(hashtags);
        THashtagModelChart hashtagModelChart = new THashtagModelChart();
        List<String> hashtagsTwitter = twitterHashtagService.getAllHashtagsByTwitter(twitter);
        if (hashtagsTwitter.isEmpty() || not_screen_name == 0) {
            analysisChart.setH_model(null);
        } else {
            hashtagModelChart.setName(String.join(", ", hashtagsTwitter));
            hashtagModelChart.setS_positive((int) (((double) h_s_positive / (double) not_screen_name) * 100));
            hashtagModelChart.setS_neutral((int) (((double) h_s_neutral / (double) not_screen_name) * 100));
            hashtagModelChart.setS_negative((int) (((double) h_s_negative / (double) not_screen_name) * 100));
            hashtagModelChart.setQ_true((int) (((double) h_q_true / (double) not_screen_name) * 100));
            hashtagModelChart.setQ_false((int) (((double) h_q_false / (double) not_screen_name) * 100));
            hashtagModelChart.setN_true((int) (((double) h_n_true / (double) not_screen_name) * 100));
            hashtagModelChart.setN_fake((int) (((double) h_n_false / (double) not_screen_name) * 100));
            analysisChart.setH_model(hashtagModelChart);
        }

        return analysisChart;
    }
}
