package com.togetherness.security.service;

import org.springframework.stereotype.Service;

import com.togetherness.security.model.BaseUser;

@Service
public class UserService {

    public BaseUser findUserByUsername(String username){
        return new BaseUser();
    }

    public void Save(BaseUser user){
    }
}
