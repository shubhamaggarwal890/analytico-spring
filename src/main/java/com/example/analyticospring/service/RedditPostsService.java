package com.example.analyticospring.service;

import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.FacebookPosts;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.RedditPosts;
import com.example.analyticospring.repository.RedditPostsRepository;
import com.example.analyticospring.service.implementation.RedditPostsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RedditPostsService implements RedditPostsServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(RedditPostsService.class);
    private RedditPostsRepository redditPostsRepository;

    @Autowired
    public void setRedditPostsRepository(RedditPostsRepository redditPostsRepository) {
        this.redditPostsRepository = redditPostsRepository;
    }

    public RedditPosts addRedditPostsInstance(String author, String link, Integer ups, String posts,
                                              Double sentimental, Integer comments, Reddit reddit) {
        RedditPosts redditPosts = new RedditPosts();
        redditPosts.setAuthor(author);
        redditPosts.setLink(link);
        redditPosts.setUps(ups);
        redditPosts.setPosts(posts.substring(0, Math.min(posts.length(), 500)));
        redditPosts.setSentimental(sentimental);
        redditPosts.setComments(comments);
        redditPosts.setReddit(reddit);
        try {
            redditPosts = redditPostsRepository.save(redditPosts);
            logger.info("reddit {} post successfully saved along with analysis in to database", reddit.getId());
            return redditPosts;

        } catch (DataAccessException error) {
            logger.error("Error while saving the reddit {} post, {}", reddit.getId(), error.getLocalizedMessage());
        }
        return null;
    }

    public List<RedditPosts> getPostsByReddit(Reddit reddit){
        return redditPostsRepository.findRedditPostsByReddit(reddit);
    }

    public List<Object []> getTopPostsByUpsReddit(Reddit reddit){
        return redditPostsRepository.findRedditPostsUpsByReddit(reddit);
    }


}
