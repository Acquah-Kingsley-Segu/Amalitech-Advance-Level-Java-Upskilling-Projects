package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Controller
    public static class DemoController{
        @GetMapping("/homepage")
        public String homepage(){
            return "homepage";
        }
    }
}