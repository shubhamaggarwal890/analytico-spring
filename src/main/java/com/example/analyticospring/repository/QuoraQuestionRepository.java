package com.example.analyticospring.repository;

import com.example.analyticospring.entity.QuoraQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoraQuestionRepository extends CrudRepository<QuoraQuestion, Integer> {
}
