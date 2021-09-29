package com.example.hansrajcollege.models;

public class FacultyLoginResponse {
    private String uid;
    private int role;
    private com.example.hansrajcollege.models.token token;
    private String name, department, email;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public com.example.hansrajcollege.models.token getToken() {
        return token;
    }

    public void setToken(com.example.hansrajcollege.models.token token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
