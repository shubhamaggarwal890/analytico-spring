package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRedditAnalysis {
    private String comment;
    private String author;
    private Double controversial;
    private Integer ups;
    private Double sentimental;
}
