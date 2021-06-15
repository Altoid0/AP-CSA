package com.freekash.springboot;

import com.freekash.springboot.database.CommentSqlRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.freekash.springboot.database.Comment;
import org.springframework.web.bind.annotation.*;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.validation.Valid;
import java.util.List;

import java.util.List;
import java.util.stream.Stream;

@Controller
public class ApplicationController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/how")
    public String how() {
        return "how.html";
    }

    @GetMapping("/about")
    public String about() {
        return "about.html";
    }

    @GetMapping("/misc")
    public String misc() {
        return "misc.html";
    }

    @GetMapping("/crossover")
    public String crossover() {
        return "crossover.html";
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


    @Autowired
    private CommentSqlRepository commentSqlRepository;

    @GetMapping("/comments")
    public String comments(Model model){
        model.addAttribute("comments", commentSqlRepository.listAllComments());
        return "comments.html";
    }

    @PostMapping("/comments")
    public String playerSave(@Valid Comment comment, BindingResult bindingResult) {
        // Validation of Decorated PlayerForm attributes
        if (bindingResult.hasErrors()) {
            return "comments";
        }
        commentSqlRepository.save(comment);
        // Redirect to next step
        return "redirect:/";
    }
}
