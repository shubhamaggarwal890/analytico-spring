package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comments {
    private @Id
    @GeneratedValue
    Integer id;

    private String commenting_user;
    private String comment_url;

    @Lob
    @Column(length = 1024)
    private String comment;

    private String sentimental_remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post")
    private Reddit post;

}
