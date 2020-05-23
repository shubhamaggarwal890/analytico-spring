package com.example.analyticospring.repository;

import com.example.analyticospring.entity.FacebookPosts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookPostRepository extends CrudRepository<FacebookPosts, Integer> {
}
