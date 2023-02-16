package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/")
    public String index(){
        return "this is a test text";
    }

    @GetMapping("/test")
    public String test(){
        return "this is a test";
    }
}
