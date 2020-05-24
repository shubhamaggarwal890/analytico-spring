package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.FacebookPosts;
import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.Twitter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacebookPostRepository extends CrudRepository<FacebookPosts, Integer> {

    @Query(value = "select a from FacebookPosts a where a.facebook=?1")
    List<FacebookPosts> findFacebookPostsByFacebook(Facebook facebook);

}
