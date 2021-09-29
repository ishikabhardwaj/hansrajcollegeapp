package com.example.hansrajcollege.models;

public class LoginRequest {
    private String uid;
    private String password;
    private int role;

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
}
