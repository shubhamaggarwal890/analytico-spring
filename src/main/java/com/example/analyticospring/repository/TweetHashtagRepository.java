package com.example.analyticospring.repository;

import com.example.analyticospring.entity.TweetHashtag;
import com.example.analyticospring.entity.TwitterHashtag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetHashtagRepository extends CrudRepository<TweetHashtag, Integer> {
}
