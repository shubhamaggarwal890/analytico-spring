package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Twitter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends CrudRepository<Twitter, Integer> {
}
