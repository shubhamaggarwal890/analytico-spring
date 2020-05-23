package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Tweet;
import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.TwitterHashtag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitterHashtagRepository extends CrudRepository<TwitterHashtag, Integer> {
    @Query(value = "select a.name from TwitterHashtag a where a.twitter=?1")
    List<String> findHashtagByTwitter(Twitter twitter);

}
