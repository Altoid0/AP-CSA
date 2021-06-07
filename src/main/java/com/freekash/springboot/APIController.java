package com.freekash.springboot;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class APIController {

    @GetMapping("/test")
    public String test(){
        return "index.html";
    }

    @RequestMapping(value = "/comments")
    public ResponseEntity<String> getAllPosts(){
        JSONObject object = new JSONObject();
        object.put("link", "test_data");
        object.put("unit", 1);
        JSONArray arr = new JSONArray();
        arr.add(object);
        return new ResponseEntity<>(arr.toJSONString(), HttpStatus.OK);
    }

}
