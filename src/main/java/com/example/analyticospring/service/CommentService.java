package com.example.analyticospring.service;

import com.example.analyticospring.entity.Comments;
import com.example.analyticospring.entity.Posts;
import com.example.analyticospring.repository.CommentsRepository;
import com.example.analyticospring.service.implementation.CommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentService implements CommentServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
    private CommentsRepository commentsRepository;

    @Autowired
    public void setCommentsRepository(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comments addCommentInstance(String commenting_user, String comment_url, String comment, String sentimental,
                                       Posts posts) {
        Comments comments = new Comments();
        comments.setCommenting_user(commenting_user);
        comments.setComment_url(comment_url);
        comments.setComment(comment);
        comments.setSentimental_remarks(sentimental);
        comments.setPost(posts);
        try {
            comments = commentsRepository.save(comments);
            logger.info("comment of reddit post {} successfully saved in to database", posts.getId());
            return comments;

        } catch (DataAccessException error) {
            logger.error("Error while saving the comment of reddit post {}, {}", posts.getId(), error.getLocalizedMessage());
        }
        return null;
    }

}
