package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reddit_comments")
public class RedditComments {
    private @Id
    @GeneratedValue
    Integer id;

    private String author;

    @Lob
    @Column(length = 512)
    private String comment;

    private Double sentimental;
    private Double controversy;
    private Integer ups;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post")
    private RedditPosts post;

}
