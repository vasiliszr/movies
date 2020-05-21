package com.aueb.movies.controller;

import com.aueb.movies.dao.UsersDAO;
import com.aueb.movies.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

//   @Autowired
//   UsersDAO usersDAO;

    private List<User> users = new ArrayList<>();
    private int nextID;

    @PostMapping("/register")
    public User success(@RequestBody User user) {
        System.out.println("reg post");
        user.setId(nextID++);
        users.add(user);
        System.out.println(users);
        return user;
    }

    @PostMapping("/login")
    public User log(@RequestBody User user) {
        System.out.println("log post");
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
            System.out.println("login successful");
        } else {
            System.out.println("login failed --- " + errormsg);
        }
        return logged;
    }

}
