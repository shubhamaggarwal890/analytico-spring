package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "facebook_hashtag")
public class FacebookHashtag {
    private @Id
    @GeneratedValue
    Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts")
    private FacebookPosts post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facebook")
    private Facebook facebook;


}
