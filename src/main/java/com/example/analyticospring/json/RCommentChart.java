package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RCommentChart {
    List<HashtagAnalysisChart> ups = new ArrayList<>();
    Integer s_positive;
    Integer s_negative;
    Integer s_neutral;
    Integer c_positive;
    Integer c_negative;


}
