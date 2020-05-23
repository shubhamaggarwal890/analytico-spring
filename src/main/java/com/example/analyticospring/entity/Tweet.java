package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tweet {
    private @Id
    @GeneratedValue
    Integer id;

    private String  screen_name;
    private String  link;
    private String  tweet;
    private Double  sentimental;
    private Double  news;
    private Double  question;
    private Integer hashtags;
    private boolean from_screen_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "twitter")
    private Twitter twitter;

}
