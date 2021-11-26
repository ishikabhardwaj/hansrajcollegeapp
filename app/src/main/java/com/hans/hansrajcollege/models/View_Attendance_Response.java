package com.hans.hansrajcollege.models;

public class View_Attendance_Response {
    String subject;
    int attendance,out_of;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getOut_of() {
        return out_of;
    }

    public void setOut_of(int out_of) {
        this.out_of = out_of;
    }
}
