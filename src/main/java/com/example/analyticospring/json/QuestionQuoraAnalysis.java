package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionQuoraAnalysis {
    private String question;
    private Integer answer_count;
    private String link;
    private List<AnswerQuoraAnalysis> answers = new ArrayList<>();
}
