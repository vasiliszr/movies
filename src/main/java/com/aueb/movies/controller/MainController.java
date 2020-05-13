package com.aueb.movies.controller;

import com.aueb.movies.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private UsersDAO user;

    @RequestMapping("/")
    public String HomeController() {
        return "index";
    }



}
