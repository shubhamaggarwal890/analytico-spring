package com.example.analyticospring.repository;

import com.example.analyticospring.entity.TwitterHashtag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterHashtagRepository extends CrudRepository<TwitterHashtag, Integer> {
}
