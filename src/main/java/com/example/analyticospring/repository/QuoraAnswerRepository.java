package com.example.analyticospring.repository;

import com.example.analyticospring.entity.QuoraAnswers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoraAnswerRepository extends CrudRepository<QuoraAnswers, Integer> {
}
