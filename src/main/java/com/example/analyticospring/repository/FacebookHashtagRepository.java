package com.example.analyticospring.repository;

import com.example.analyticospring.entity.FacebookHashtag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookHashtagRepository extends CrudRepository<FacebookHashtag, Integer> {
}
