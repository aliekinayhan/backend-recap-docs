package com.ayhanekin.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greeting (HttpServletRequest request) {
        return "Hello World!" + request.getSession().getId();
        // Session id is the thing we are holding to stay connected to an application and not
        // type in username and password again and again

    }
    @GetMapping("/hello2")
    public String greeting2 (HttpServletRequest request) {
        return "SessionId check" + request.getSession().getId();
    }

}
