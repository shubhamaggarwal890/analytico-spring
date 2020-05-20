package com.example.analyticospring.json;

import com.example.analyticospring.entity.Analyzer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FacebookRequest {
    private Integer user_id;
    private String token;
    private String email;
    private String name;
    private String page;
    private Analyzer analyzer;

}
