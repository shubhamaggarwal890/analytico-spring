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
public class Facebook {
    private @Id
    @GeneratedValue
    Integer id;

    private String email;
    private String name;
    private String page;

    private Integer friends_count;

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
