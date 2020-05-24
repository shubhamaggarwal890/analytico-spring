package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.Reddit;
import com.example.analyticospring.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditRepository extends CrudRepository<Reddit, Integer> {

    @Query(value = "select a from Reddit a where a.user=?1 ORDER BY a.id DESC")
    List<Reddit> findRedditByUser(User user);

}
