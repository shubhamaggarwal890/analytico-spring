package com.example.analyticospring.repository;

import com.example.analyticospring.entity.Facebook;
import com.example.analyticospring.entity.FacebookHashtag;
import com.example.analyticospring.entity.Twitter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacebookHashtagRepository extends CrudRepository<FacebookHashtag, Integer> {

    @Query(value = "select a.name as name, count(a.name) as number from facebook_hashtag a group by name, a.facebook " +
            "having a.facebook=?1 ORDER BY number DESC LIMIT 7", nativeQuery = true)
    List<Object[]> findFacebookHashtagByFacebook(Facebook facebook);

}
