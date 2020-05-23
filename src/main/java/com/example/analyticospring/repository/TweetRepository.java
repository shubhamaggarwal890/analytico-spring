package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Integer> {

    @Query(value = "select a from Tweet a where a.twitter=?1")
    List<Tweet> findTweetByTwitter(Twitter twitter);
}
