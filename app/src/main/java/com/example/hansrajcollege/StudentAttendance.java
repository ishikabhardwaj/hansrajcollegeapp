package com.example.hansrajcollege;

public class StudentAttendance {
    private String MSubject;
    private  String Mmonth;
    private String MAttendance;
    private String MPercentage;

    public StudentAttendance(String subject,String month, String Attendance, float Percentage)
    {
        MSubject=subject;
        Mmonth=month;
        MAttendance="Attendance: "+Attendance;
        MPercentage=Float.toString(Percentage)+"%";
    }

    public String getMSubject() {
        return MSubject;
    }
    public String getMmonth() {
        return Mmonth;
    }
    public String getMAttendance() {
        return MAttendance;
    }
    public String getMPercentage() {
        return MPercentage;
    }
}
