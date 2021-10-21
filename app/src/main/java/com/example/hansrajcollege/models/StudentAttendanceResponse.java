package com.example.hansrajcollege.models;

public class StudentAttendanceResponse {
    int total_attendance,RollNo,Attendance;
    String Name;

    public int getTotal_attendance() {
        return total_attendance;
    }

    public void setTotal_attendance(int total_attendance) {
        this.total_attendance = total_attendance;
    }

    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }

    public int getAttendance() {
        return Attendance;
    }

    public void setAttendance(int attendance) {
        Attendance = attendance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
