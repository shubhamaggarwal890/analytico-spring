package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "twitter_hashtag")
public class TwitterHashtag {
    private @Id
    @GeneratedValue
    Integer id;
    private String name;
    private boolean analysis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tweet")
    private Tweet tweet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "twitter")
    private Twitter twitter;

}
