package com.aueb.movies.controllers;

import com.aueb.movies.model.User;
import com.aueb.movies.repo.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllers {

    @Autowired
    private UserService userService;
    private List<User> users = new ArrayList<>();

    @PostMapping(value = "/register", consumes = "application/json")
    public User success(@RequestBody User user) {
        System.out.println("reg post");
        users.add(user);
        User existed = userService.findByEmail(user.getEmail());
        if (existed != null){
            System.out.println("user already exists!");
            return new User();
        }
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
