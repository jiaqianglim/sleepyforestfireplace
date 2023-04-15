package com.togetherness.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.togetherness.security.model.BaseUser;
import com.togetherness.security.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public BaseUser getUserByUsername(@RequestBody BaseUser user) {
        return null;
    }

    @GetMapping
    ResponseEntity<String> findUsernameExists(@PathVariable("id") String username) {
        return null;
    }

    @PostMapping
    ResponseEntity<String> postUser(@RequestBody String user) {
        return null;
    }

}
