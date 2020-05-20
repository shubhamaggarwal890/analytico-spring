package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {
}
