package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QueryQuoraAnalysis {
    private String question;
    private String answer;
    private Double sentimental;
    private String author;
    private String link;
    private Integer answer_count;
}
