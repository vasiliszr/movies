package com.aueb.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String HomeController() {
        System.out.println("home");
        return "index";
    }

    @GetMapping("/login")
    public String LoginController() {
        return "login";
    }

}
