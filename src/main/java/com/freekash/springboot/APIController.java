package com.freekash.springboot;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class APIController {

    @GetMapping("")
    public String getAllPosts(){
        JSONObject object = new JSONObject();
        object.put("link", "test_data");
        object.put("unit", 1);
        JSONArray arr = new JSONArray();
        arr.add(object);
        return arr.toJSONString();
    }

}
