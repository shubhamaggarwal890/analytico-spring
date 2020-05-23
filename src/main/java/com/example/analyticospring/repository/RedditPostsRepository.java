package com.example.analyticospring.repository;

import com.example.analyticospring.entity.RedditPosts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditPostsRepository extends CrudRepository<RedditPosts, Integer> {
}
