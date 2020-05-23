package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RedditPosts {
    private @Id
    @GeneratedValue
    Integer id;

    private String author;
    private String link;
    private Integer ups;

    @Lob
    @Column(length = 8192)
    private String posts;

    private Double sentimental;
    private Integer comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reddit")
    private Reddit reddit;


}
