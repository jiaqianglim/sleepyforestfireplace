package com.togetherness.security.model;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class UserPrincipal extends BaseUser {

    @Autowired
    BaseUser baseUser;

    @Override
    public String getUsername() {
        return this.baseUser.getUsername();
    }

    @Override
    public Collection<String> getRoles() {
        return this.baseUser.getRoles();
    }

    @Override
    public String getPassword() {
        return null;
    }
}
