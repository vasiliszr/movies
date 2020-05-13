package com.aueb.movies.controller;

import com.aueb.movies.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UsersDAO user;

    @GetMapping("/")
    public String HomeController() {
        return "index";
    }

    @GetMapping("/login")
    public String LoginController() {
        return "login";
    }

    @GetMapping("/register")
    public String RegisterController() {
        return "register";
    }



}
