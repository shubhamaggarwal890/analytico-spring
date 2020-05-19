package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Answers {
    private @Id
    @GeneratedValue
    Integer id;

    private String answerer;
    private String answer_url;

    @Lob
    @Column(length = 4096)
    private String answer;

    private String sentimental_remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private Question question;

}
