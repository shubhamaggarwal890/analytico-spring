package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question {
    private @Id
    @GeneratedValue
    Integer id;

    @Lob
    @Column(length = 255)
    private String question;
    private String question_url;

    private boolean from_question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quora")
    private Quora quora;


}
