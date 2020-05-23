package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HashtagAnalysisResponse {
    private String name;
    private String post;
    private Double sentimental;
    private Double news;
    private Double question;
    private List<HashtagRequest> hashtags = new ArrayList<>();

}
