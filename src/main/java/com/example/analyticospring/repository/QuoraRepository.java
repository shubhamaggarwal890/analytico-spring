package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Quora;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoraRepository extends CrudRepository<Quora, Integer> {

    @Query(value = "select a from Quora a where a.user=?1 ORDER BY a.id DESC")
    List<Quora> findQuoraByUser(User user);

}
