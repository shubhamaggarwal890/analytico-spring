package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "quora_answers")
public class QuoraAnswers {
    private @Id
    @GeneratedValue
    Integer id;

    private String author;

    @Lob
    @Column(length = 512)
    private String answer;

    private Double sentimental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private QuoraQuestion question;

}
