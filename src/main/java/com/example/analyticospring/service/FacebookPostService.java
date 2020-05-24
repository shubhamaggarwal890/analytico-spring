package com.example.analyticospring.service;

import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.FacebookPosts;
import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.repository.FacebookPostRepository;
import com.example.analyticospring.service.implementation.FacebookPostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacebookPostService implements FacebookPostServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(FacebookPostService.class);
    private FacebookPostRepository facebookPostRepository;

    @Autowired
    public void setFacebookPostRepository(FacebookPostRepository facebookPostRepository) {
        this.facebookPostRepository = facebookPostRepository;
    }

    public FacebookPosts addPostInstance(String post, Double sentimental, Double question, Integer hashtags,
                                         boolean page, Facebook facebook) {
        FacebookPosts facebookPosts = new FacebookPosts();
        facebookPosts.setPosts(post.substring(0, Math.min(post.length(), 500)));
        facebookPosts.setSentimental(sentimental);
        facebookPosts.setQuestion(question);
        facebookPosts.setFacebook(facebook);
        facebookPosts.setFrom_page(page);
        facebookPosts.setHashtags(hashtags);
        try {
            facebookPosts = facebookPostRepository.save(facebookPosts);
            logger.info("facebook {} post successfully saved along with analysis in to database for", facebook.getId());
            return facebookPosts;

        } catch (DataAccessException error) {
            logger.error("Error while saving the facebook {} post, {}", facebook.getId(), error.getLocalizedMessage());
        }
        return null;
    }

    public List<FacebookPosts> getPostsByFacebook(Facebook facebook){
        return facebookPostRepository.findFacebookPostsByFacebook(facebook);
    }

}
