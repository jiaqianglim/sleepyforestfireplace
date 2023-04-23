package com.hype.webmvc._security.model;

import java.io.Serializable;

public class AuthRes implements Serializable{
    private String token;

    /**
     * @param token
     */
    public AuthRes(String token) {
        this.token = token;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    

}
