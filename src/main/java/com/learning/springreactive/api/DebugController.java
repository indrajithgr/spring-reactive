package com.learning.springreactive.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-reactive")
public class DebugController {

    @GetMapping
    public String getDebugMessage(){
        return "Hi, I'm alive and available here.";
    }

}
