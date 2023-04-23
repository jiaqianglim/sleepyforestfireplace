package com.hype.webmvc._security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hype.webmvc._security.model.AuthReq;
import com.hype.webmvc._security.model.AuthRes;
import com.hype.webmvc._security.model.BasicUser;

@Controller
public class UserController {

    @Autowired
    UserService usvc;
    @Autowired
    JwtService jsvc;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public BasicUser createUser(@Payload BasicUser user) {
        return usvc.createUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthRes loginUser(@Payload BasicUser inputuser) {
        BasicUser responseUser = usvc.authenticate(inputuser.getEmail(), inputuser.getPassword());
        String jwt = jsvc.generateToken(responseUser);
        return new AuthRes(jwt);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable("email") String email) {
        usvc.removeUserByEmail(email);
    }

    @PutMapping("/api/users/{id}")
    public void putUserById(@PathVariable("email") String email, @RequestBody BasicUser user) {
        usvc.updateUser(user);

    }

    @RequestMapping(value = "/authenticate")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthRes authenticate(@RequestBody AuthReq req) throws Exception {
        BasicUser user;
        try {
            user = usvc.authenticate(req.getEmail(), req.getPassword());
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        BasicUser responseUser = usvc.authenticate(user.getEmail(), user.getPassword());
        String jwt = jsvc.generateToken(responseUser);
        return new AuthRes(jwt);
    }

}
