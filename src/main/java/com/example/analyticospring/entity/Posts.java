package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Posts {
    private @Id
    @GeneratedValue
    Integer id;

    private String post_user;
    private String post_url;

    @Lob
    @Column(length = 8192)
    private String posts;

    private String sentimental_remarks;
    private String news_remark;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facebook")
    private Facebook facebook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reddit")
    private Reddit reddit;
}
