package com.togetherness.security.model;

public class UserEntity {
    private String id;
    private String email;
    private byte[] storedHash;
    private byte[] storedSalt;

    public UserEntity() {
    }

    public UserEntity(String id, String email, byte[] storedHash, byte[] storedSalt) {
        this.id = id;
        this.email = email;
        this.storedHash = storedHash;
        this.storedSalt = storedSalt;
    }

    public UserEntity(String email) {
        this.email = email;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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

    public byte[] getStoredHash() {
        return storedHash;
    }

    public void setStoredHash(byte[] storedHash) {
        this.storedHash = storedHash;
    }

    public byte[] getStoredSalt() {
        return storedSalt;
    }

    public void setStoredSalt(byte[] storedSalt) {
        this.storedSalt = storedSalt;
    }

}
