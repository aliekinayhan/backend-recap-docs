package com.ayhanekin.JWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello () {
        return "We are in";
    }

    @GetMapping("/hello")
    public String home() {
        return "Home page";
    }

}
