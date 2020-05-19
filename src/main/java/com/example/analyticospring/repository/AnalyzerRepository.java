package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Analyzer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzerRepository extends CrudRepository<Analyzer, Integer> {
}
