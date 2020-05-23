package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnswerQuoraAnalysis {
    private String answer;
    private String author;
    private Double sentimental;
}
