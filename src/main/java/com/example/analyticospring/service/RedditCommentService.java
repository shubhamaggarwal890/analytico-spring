package com.example.analyticospring.service;

import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.RedditComments;
import com.example.analyticospring.entity.RedditPosts;
import com.example.analyticospring.repository.RedditCommentsRepository;
import com.example.analyticospring.service.implementation.RedditCommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RedditCommentService implements RedditCommentServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(RedditCommentService.class);
    private RedditCommentsRepository redditCommentsRepository;

    @Autowired
    public void setRedditCommentsRepository(RedditCommentsRepository redditCommentsRepository) {
        this.redditCommentsRepository = redditCommentsRepository;
    }

    public RedditComments addCommentInstance(String author, String comment, Double sentimental, Double controversy,
                                             Integer ups, RedditPosts post, Reddit reddit) {
        RedditComments comments = new RedditComments();
        comments.setAuthor(author);
        comments.setComment(comment.substring(0, Math.min(comment.length(), 500)));
        comments.setSentimental(sentimental);
        comments.setControversy(controversy);
        comments.setUps(ups);
        comments.setPost(post);
        comments.setReddit(reddit);
        try {
            comments = redditCommentsRepository.save(comments);
            logger.info("comment of reddit post {} successfully saved in to database", post.getId());
            return comments;
        } catch (DataAccessException error) {
            logger.error("Error while saving the comment of reddit post {}, {}", post.getId(),
                    error.getLocalizedMessage());
        }
        return null;
    }

    public List<RedditComments> getPostCommentsByReddit(Reddit reddit){
        return redditCommentsRepository.findRedditCommentByReddit(reddit);
    }

    public List<Object []> getTopCommentsByUpsReddit(Reddit reddit){
        return redditCommentsRepository.findRedditCommentsUpsByReddit(reddit);
    }


}
