package com.aueb.movies.controllers;

import com.aueb.movies.model.User;
import com.aueb.movies.repo.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllers {

    @Autowired
    private UserService userService;

    private List<User> users = new ArrayList<>();

    @PostMapping("/register")
    public User success(@RequestBody User user) {
        System.out.println("reg post");
        users.add(user);
        userService.save(user);
        System.out.println(users);
        return user;
    }

    @PostMapping("/login")
    public User log(@RequestBody User user) {
        System.out.println("log post");
        User log = userService.findByEmail(user.getEmail());
        User logged = null;
        String errormsg = null;
        for (User u: users) {
            if (u.getEmail().equals(user.getEmail())) {
                if (u.getPassword().equals(user.getPassword())) {
                    logged = u;
                    break;
                } else {
                    errormsg = "invalid password";
                    break;
                }
            }
            errormsg = "user no found" ;
        }

        if (logged != null) {
            System.out.println("login successful --- " + logged);
        } else {
            System.out.println("login failed --- " + errormsg);
        }
        return log;
    }

}
