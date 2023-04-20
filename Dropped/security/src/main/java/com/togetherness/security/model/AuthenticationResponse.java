package com.togetherness.security.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private String token;

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(String token) {
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