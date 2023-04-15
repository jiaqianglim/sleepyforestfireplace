package com.togetherness.security.model;

import java.util.Collection;

public class BaseUser {
    String username;
    String password;
    Collection<String> roles;

    /**
     * 
     */
    public BaseUser() {
    }

    /**
     * @param username
     */
    public BaseUser(String username) {
        this.username = username;
    }

    /**
     * @param username
     * @param password
     * @param roles
     */
    public BaseUser(String username, String password, Collection<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the roles
     */
    public Collection<String> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    

}
