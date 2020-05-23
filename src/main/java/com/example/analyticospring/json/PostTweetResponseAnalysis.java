package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostTweetResponseAnalysis {
    private String screen_name;
    private String link;
    private String post;
    private Double sentimental;
    private Double news;
    private Double question;
    private Integer hashtag_count;
    private List<HashtagRequest> hashtags = new ArrayList<>();

}
