package com.freekash.springboot;

import org.springframework.web.bind.annotation.GetMapping;

public class ApplicationController {
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
}
