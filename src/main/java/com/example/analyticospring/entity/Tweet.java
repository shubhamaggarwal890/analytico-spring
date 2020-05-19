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

    private String screen_name;
    private String screen_name_url;
    private String tweet;
    private String sentimental_remark;
    private String news_remark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "twitter")
    private Twitter twitter;



}
