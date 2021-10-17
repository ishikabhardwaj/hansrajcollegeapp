package com.example.hansrajcollege.models;

public class StudentLoginResponse {
    private String uid;
    private int role;
    private com.example.hansrajcollege.models.token token;
    private String name,email,course,university_roll_no;
    private int semester;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversity_roll_no() {
        return university_roll_no;
    }

    public void setUniversity_roll_no(String university_roll_no) {
        this.university_roll_no = university_roll_no;
    }
}
