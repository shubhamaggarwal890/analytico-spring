package com.example.analyticospring.json;

import com.example.analyticospring.entity.Analyzer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuoraRequest {
    private Integer user_id;
    private String query;
    private String question;
    private String page;
    private Analyzer analyzer;

}
