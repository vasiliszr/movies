package com.aueb.movies.controllers;

import com.aueb.movies.model.Bookmark;
import com.aueb.movies.model.User;
import com.aueb.movies.service.BookmarkService;
import com.aueb.movies.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/register")
    public User Register(@RequestBody User user) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            System.out.println(user + " : user already exists");
            return new User(-1);
        }
        userService.save(user);
        System.out.println(user + " : new user created");
        return new User(user.getId(), user.getEmail());
    }

    @PostMapping("/login")
    public User Login(@RequestBody User user) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing == null) {
            System.out.println(user + " : user not found");
            return new User(-1);
        } else {
            if (user.getPassword().equals(existing.getPassword())) {
                System.out.println(user + " : user connected");
                return new User(existing.getId(), existing.getEmail());
            } else {
                System.out.println(user + " : wrong password");
                return new User(-2);
            }
        }
    }

    @GetMapping("/bookmarks/{id}")
    public List<Bookmark> GetBookmarks(@PathVariable("id") int id) {
        System.out.println("returning bookmarks for user " + id);
        return bookmarkService.findAllById(id);
    }

    @PostMapping("/home/{id}/{movie_id}")
    public void SaveBookmark(@PathVariable("id") int id, @PathVariable("movie_id") int movie_id) {
        Bookmark bookmark = new Bookmark(id, movie_id);
        bookmarkService.save(bookmark);
    }

}