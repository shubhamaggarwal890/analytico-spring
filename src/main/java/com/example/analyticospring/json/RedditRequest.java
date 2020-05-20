package com.example.analyticospring.json;

import com.example.analyticospring.entity.Analyzer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RedditRequest {
    private Integer user_id;
    private String subreddit;
    private Analyzer analyzer;
}
