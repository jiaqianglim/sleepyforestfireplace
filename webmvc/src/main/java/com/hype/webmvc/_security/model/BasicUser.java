package com.hype.webmvc._security.model;

public class BasicUser {
    private String email;
    private String password;
    private String username;
    private String membership;

    /**
     * 
     */
    public BasicUser() {
    }

    /**
     * @param email
     * @param password
     * @param username
     * @param membership
     */
    public BasicUser(String email, String password, String username, String membership) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.membership = membership;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the membership
     */
    public String getMembership() {
        return membership;
    }

    /**
     * @param membership the membership to set
     */
    public void setMembership(String membership) {
        this.membership = membership;
    }

}
