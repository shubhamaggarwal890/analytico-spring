package com.example.analyticospring.repository;

import com.example.analyticospring.entity.RedditComments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditCommentsRepository extends CrudRepository<RedditComments, Integer> {
}
