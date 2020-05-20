package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Posts, Integer> {
}
