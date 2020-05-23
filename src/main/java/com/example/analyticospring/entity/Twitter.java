package com.example.analyticospring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Twitter {
    private @Id
    @GeneratedValue
    Integer id;
    private String screen_name;
    private Integer followers;
    private Integer following;
    private boolean analysis;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiator")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analyzer")
    private Analyzer analyzer;



}
