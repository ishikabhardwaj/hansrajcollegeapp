package com.example.hansrajcollege;

public class AttendanceClass {
    private int mRollno;
    private String mName;
    private String mCourse;
    private int mAttended;
    static int mGiven;
    public AttendanceClass(int rollno, String name, String Course, int attended){
        mRollno=rollno;
        mName=name;
        mCourse=Course;
        mAttended=attended;
    }
    public int getmRollno() {
        return mRollno;
    }

    public String getmName() {
        return mName;
    }

    public String getmCourse() {
        return mCourse;
    }

    public int getmAttended() {
        return mAttended;
    }

    public static int getmGiven() {
        return mGiven;
    }
}
