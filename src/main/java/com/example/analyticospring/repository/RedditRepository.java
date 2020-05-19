package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Reddit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditRepository extends CrudRepository<Reddit, Integer> {
}
