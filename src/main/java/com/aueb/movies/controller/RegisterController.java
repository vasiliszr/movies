package com.aueb.movies.controller;

import com.aueb.movies.dao.UsersDAO;
import com.aueb.movies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    public UsersDAO usersDAO;

    @GetMapping("/register")
    public String register() {
        System.out.println("reg get");
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView success(String id, String name, String password) {
        System.out.println("reg post");
        ModelAndView mv = new ModelAndView();
        User user = new User(Integer.parseInt(id), name, password);
        usersDAO.register(user);
        mv.addObject("id", id);
        mv.addObject("name", name);
        mv.addObject("password",password);
        mv.setViewName("home");
        return mv;
    }

}
