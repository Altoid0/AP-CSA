package com.freekash.springboot;

import org.springframework.web.bind.annotation.GetMapping;

public class ApplicationController {
    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/misc")
    public String misc(){
        return "misc.html";
    }

    @GetMapping("/4")
    public String iteration(){
        return "4.html";
    }

    @GetMapping("/5")
    public String classes(){
        return "5.html";
    }

    @GetMapping("/6")
    public String arrays(){
        return "6.html";
    }

    @GetMapping("/7")
    public String arraylists(){
        return "7.html";
    }

    @GetMapping("/8")
    public String arrays2d(){ return "8.html"; }

    @GetMapping("/9")
    public String inheritance(){
        return "9.html";
    }

    @GetMapping("/10")
    public String recursion(){
        return "10.html";
    }

}
