package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QAnalysisChart {
    String message;
    String query;
    String question;
    Integer question_count;
    Integer answer_count;
    List<HashtagAnalysisChart> answers = new ArrayList<>();
    Integer s_positive;
    Integer s_negative;
    Integer s_neutral;
    Integer q_s_positive;
    Integer q_s_negative;
    Integer q_s_neutral;
}
