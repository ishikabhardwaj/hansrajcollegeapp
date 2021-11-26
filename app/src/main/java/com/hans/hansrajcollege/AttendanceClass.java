package com.hans.hansrajcollege;

public class AttendanceClass {
    private int mRollno;
    private String mName;
    private String mCourse;
    private int mAttended;
    private int mGiven;
    public AttendanceClass(int rollno, String name,String course, int attended ,int given){
        mRollno=rollno;
        mName=name;
        mCourse=course;
        mAttended=attended;
        mGiven=given;
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

    public  int getmGiven() {
        return mGiven;
    }
}
