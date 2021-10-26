package com.example.hansrajcollege.models;

import com.google.gson.JsonArray;

import org.json.JSONArray;

public class UploadStudentAttendanceRequest {
    int subject_id, total_lectures;
    String month;
    JsonArray data;

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getTotal_lectures() {
        return total_lectures;
    }

    public void setTotal_lectures(int total_lectures) {
        this.total_lectures = total_lectures;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public JsonArray getData() {
        return data;
    }

    public void setData(JsonArray data) {
        this.data = data;
    }
}
