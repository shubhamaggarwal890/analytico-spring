package com.example.analyticospring.repository;

import com.example.analyticospring.entity.TweetHashtag;
import com.example.analyticospring.entity.Twitter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetHashtagRepository extends CrudRepository<TweetHashtag, Integer> {

    @Query(value = "select a.name as name, count(a.name) as number from tweet_hashtag a group by name, a.twitter " +
            "having a.twitter=?1 ORDER BY number DESC LIMIT 7", nativeQuery = true)
    List<Object[]> findTweetHashtagByTweet(Twitter twitter);

}
