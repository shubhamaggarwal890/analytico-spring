package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostRedditAnalysis {
    private String post;
    private String author;
    private String link;
    private Integer ups;
    private Double sentimental;
    private Integer comments_count;
    private List<CommentRedditAnalysis> comments = new ArrayList<>();
}
