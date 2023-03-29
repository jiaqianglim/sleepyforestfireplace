package com.togetherness.security.model;

public class UserDTO {
    private String id;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public UserDTO(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
