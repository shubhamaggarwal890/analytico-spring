package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RAnalysisChart {
    String message;
    String subreddit;
    Integer updowns;
    Integer post_count;
    Integer comments_count;
    List<HashtagAnalysisChart> ups = new ArrayList<>();
    Integer s_positive;
    Integer s_negative;
    Integer s_neutral;
    RCommentChart comments;



}
