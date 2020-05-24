package com.aueb.movies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControllers {

    @GetMapping("/")
    public String HomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String RegisterPage() {
        return "register";
    }

    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String UserHomePage() {
        return "home";
    }

    @GetMapping("/bookmarks")
    public String BookmarksPage() {
        return "bookmarks";
    }

}