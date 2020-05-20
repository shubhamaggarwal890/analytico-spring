package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Answers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answers, Integer> {
}
