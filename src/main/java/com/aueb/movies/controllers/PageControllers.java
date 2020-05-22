package com.aueb.movies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControllers {

    @GetMapping("/")
    public String HomeController() {
        System.out.println("home");
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("reg get");
        return "register";
    }

    @GetMapping("/login")
    public String LoginController() {
        System.out.println("log get");
        return "login";
    }

}