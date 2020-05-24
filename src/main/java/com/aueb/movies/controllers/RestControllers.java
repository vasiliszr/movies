package com.aueb.movies.controllers;

import com.aueb.movies.model.User;
import com.aueb.movies.repo.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User Register(@RequestBody User user) {
        User existed = userService.findByEmail(user.getEmail());
        if (existed != null) {
            System.out.println(user + " : user already exists");
            return new User(-1);
        }
        userService.save(user);
        System.out.println(user + " : new user created");
        return new User(user.getId(), user.getEmail());
    }

    @PostMapping("/login")
    public User Login(@RequestBody User user) {
        User log = userService.findByEmail(user.getEmail());
        if (log == null) {
            System.out.println(user + " : user not found");
            return new User(-1);
        } else {
            if (user.getPassword().equals(log.getPassword())) {
                System.out.println(user + " : user connected");
                return new User(log.getId(), log.getEmail());
            } else {
                System.out.println(user + " : wrong password");
                return new User(-2);
            }
        }
    }

}
