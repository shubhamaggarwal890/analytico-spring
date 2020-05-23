package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "facebook_posts")
public class FacebookPosts {
    private @Id
    @GeneratedValue
    Integer id;

    @Lob
    @Column(length = 512)
    private String posts;

    private boolean from_page;

    private Double sentimental;
    private Double question;
    private Integer hashtags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facebook")
    private Facebook facebook;
}
