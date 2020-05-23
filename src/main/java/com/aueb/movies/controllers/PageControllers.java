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
    public String RegisterController() {
        System.out.println("reg get");
        return "register";
    }

    @GetMapping("/login")
    public String LoginController() {
        System.out.println("log get");
        return "login";
    }

    @GetMapping("/home")
    public String UserHomeController() {
        System.out.println("user home");
        return "home";
    }

    @GetMapping("/bookmarks")
    public String BookmarksController() {
        System.out.println("bookmarks");
        return "bookmarks";
    }

}