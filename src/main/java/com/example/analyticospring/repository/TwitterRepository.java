package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Twitter;
import com.example.analyticospring.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitterRepository extends CrudRepository<Twitter, Integer> {

    @Query(value = "select a from Twitter a where a.user=?1 ORDER BY a.id DESC")
    List<Twitter> findTwitterByUser(User user);

}