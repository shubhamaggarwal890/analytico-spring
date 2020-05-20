package com.example.analyticospring.service;

import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.Posts;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.repository.PostRepository;
import com.example.analyticospring.service.implementation.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostService implements PostServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Posts addPostInstance(String post_user, String post_url, String post, String sentimental, String news,
                                 Facebook facebook, Reddit reddit) {
        Posts posts = new Posts();
        posts.setPost_user(post_user);
        posts.setPost_url(post_url);
        posts.setPosts(post);
        posts.setSentimental_remarks(sentimental);
        posts.setNews_remark(news);
        posts.setFacebook(facebook);
        posts.setReddit(reddit);
        String postInstance;
        Integer id;
        if (facebook != null) {
            postInstance = "facebook";
            id = facebook.getId();
        } else {
            postInstance = "reddit";
            id = reddit.getId();
        }
        try {
            postRepository.save(posts);
            logger.info("post of {} successfully saved along with analysis in to database for {} {}", post_user,
                    postInstance, id);
            return posts;

        } catch (DataAccessException error) {
            logger.error("Error while saving the post of {} for {} {}, {}", post_user, postInstance, id,
                    error.getLocalizedMessage());
        }
        return null;
    }
}
