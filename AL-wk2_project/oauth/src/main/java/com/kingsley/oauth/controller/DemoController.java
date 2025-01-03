package com.kingsley.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {
    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello Secured";
    }
}
