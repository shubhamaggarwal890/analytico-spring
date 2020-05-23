package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FacebookAnalysisResponse {
    private Integer facebook;
    private String email;
    private Integer friends;
    private List<PostTweetResponseAnalysis> posts = new ArrayList<>();
    private List<PostTweetResponseAnalysis> page_post = new ArrayList<>();
}
