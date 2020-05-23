package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuoraAnalysisResponse {
    private Integer quora;
    private String email;
    List<QueryQuoraAnalysis> query = new ArrayList<>();
    QuestionQuoraAnalysis question;


}
