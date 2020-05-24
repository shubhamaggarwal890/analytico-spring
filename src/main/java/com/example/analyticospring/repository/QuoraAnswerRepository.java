package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Quora;
import com.example.analyticospring.entity.QuoraAnswers;
import com.example.analyticospring.entity.QuoraQuestion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoraAnswerRepository extends CrudRepository<QuoraAnswers, Integer> {

    @Query(value = "select a from QuoraAnswers a where a.question=?1")
    List<QuoraAnswers> findQuoraAnswersByQuestion(QuoraQuestion quora);

    @Query(value = "select a from QuoraAnswers a where a.quora=?1")
    List<QuoraAnswers> findQuoraAnswersByQuora(Quora quora);

}
