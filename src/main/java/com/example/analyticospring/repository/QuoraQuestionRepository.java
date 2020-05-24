package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Quora;
import com.example.analyticospring.entity.QuoraQuestion;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoraQuestionRepository extends CrudRepository<QuoraQuestion, Integer> {

    @Query(value = "select a from QuoraQuestion a where a.quora=?1")
    List<QuoraQuestion> findQuoraQuestionByQuora(Quora quora);

    @Query(value = "select a.question as name, a.answers as number from quora_question a where a.quora=?1 " +
            "ORDER BY answers DESC LIMIT 7", nativeQuery = true)
    List<Object[]> findMaxQuoraAnswersByQuora(Quora q);

    @Query(value = "select a from QuoraQuestion a where a.quora=?1 and a.from_question=true ")
    List<QuoraQuestion> findQuoraQuestionUserByQuora(Quora quora);
}
