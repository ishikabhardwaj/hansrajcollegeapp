package com.hans.hansrajcollege;

public class StudentAttendance {
    private String MSubject;
    private String MAttendance;
    private String MPercentage;

    public StudentAttendance(String subject,String Attendance, float Percentage)
    {
        MSubject=subject;
        MAttendance="Attendance: "+Attendance;
        MPercentage=Float.toString(Percentage)+"%";
    }

    public String getMSubject() {
        return MSubject;
    }
    public String getMAttendance() {
        return MAttendance;
    }
    public String getMPercentage() {
        return MPercentage;
    }
}
