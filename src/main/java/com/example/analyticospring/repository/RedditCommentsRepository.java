package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.RedditComments;
import com.example.analyticospring.entity.RedditPosts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditCommentsRepository extends CrudRepository<RedditComments, Integer> {
    @Query(value = "select a from RedditComments a where a.reddit=?1")
    List<RedditComments> findRedditCommentByReddit(Reddit reddit);

    @Query(value = "select a.author as name, ups as number from reddit_comments a where a.reddit=?1 " +
            "ORDER BY ups DESC LIMIT 7", nativeQuery = true)
    List<Object[]> findRedditCommentsUpsByReddit(Reddit reddit);

}
