package com.freekash.springboot;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.freekash.springboot.database.Comment;
import com.freekash.springboot.database.CommentSqlRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private CommentSqlRepository commentSqlRepository;

    @RequestMapping(value = "/comments")
    public ResponseEntity<Object> getAllPosts(@RequestParam(value = "name", required = false) String authorName){
        Stream<Comment> comments = commentSqlRepository.listAll().stream();
        if(authorName != null)
             comments = comments.filter(comment -> {
                if(comment.getCommentAuthor().toLowerCase().equals(authorName.toLowerCase()))
                    return true;
                return false;
            });
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ResponseEntity<Object> createComment(@RequestParam("name") String name, @RequestParam("body") String body){
        Comment comment = new Comment(name, body);
        commentSqlRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
