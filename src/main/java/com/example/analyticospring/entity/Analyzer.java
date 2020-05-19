package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Analyzer {
    private @Id
    @GeneratedValue
    Integer id;
    private boolean sentimental;
    // Checking if the tweet or post is fake or not
    private boolean news;
    // Checking the count of hashtags, frequency of hashtags
    private boolean hashtags;
    // follower count of the user, in tweeter and facebook
    private boolean followers;
    // check if the produced is a question or not
    private boolean question;

}
