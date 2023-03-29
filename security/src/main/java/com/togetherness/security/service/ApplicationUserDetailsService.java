package com.togetherness.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.togetherness.security.model.UserPrincipal;

public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email){
        return new UserPrincipal(userService.findUserByUsername(email));
    }
}
