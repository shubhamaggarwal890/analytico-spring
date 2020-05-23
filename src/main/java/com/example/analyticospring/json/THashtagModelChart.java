package com.example.analyticospring.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class THashtagModelChart {
    Integer s_positive;
    Integer s_negative;
    Integer s_neutral;
    Integer q_true;
    Integer q_false;
    Integer n_true;
    Integer n_fake;
    String name;
}
