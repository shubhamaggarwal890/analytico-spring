package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TwitterAnalysisResponse {
    private List<PostTweetResponseAnalysis> tweets = new ArrayList<>();
    private List<PostTweetResponseAnalysis> hashtags = new ArrayList<>();
    private Integer followers;
    private Integer following;
    private Integer twitter;
    private String email;
}
