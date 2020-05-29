package com.example.analyticospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/sign-up", "/signin", "/dashboard", "/facebook", "/twitter", "/reddit", "/quora"})
    public String index() {
        return "index";
    }

}
