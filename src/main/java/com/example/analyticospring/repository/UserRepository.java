package com.example.analyticospring.repository;

import com.example.analyticospring.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select a from User a WHERE a.emailId = ?1")
    User getByEmailId(String emailId);

}
