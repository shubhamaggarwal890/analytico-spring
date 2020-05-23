package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TAnalysisChart {
    String message;
    Integer following;
    Integer followers;
    Integer tweets_count;
    Integer hashtags_count;
    List<HashtagAnalysisChart> hashtags = new ArrayList<>();
    Integer s_positive;
    Integer s_negative;
    Integer s_neutral;
    Integer q_true;
    Integer q_false;
    Integer n_true;
    Integer n_fake;
    THashtagModelChart h_model;
}
