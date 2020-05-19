package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Facebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookRepository extends CrudRepository<Facebook, Integer> {
}
