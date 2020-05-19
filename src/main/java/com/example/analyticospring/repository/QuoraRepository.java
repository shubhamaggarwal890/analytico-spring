package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Quora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoraRepository extends CrudRepository<Quora, Integer> {
}
