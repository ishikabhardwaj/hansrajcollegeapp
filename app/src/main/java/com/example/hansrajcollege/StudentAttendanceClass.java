package com.example.hansrajcollege;

public class StudentAttendanceClass {

    private String mName;
    private String mCourse;
    private int mRollNo;
    public StudentAttendanceClass(String name, String course, int rollno)
    {
        mName=name;
        mCourse=course;
        mRollNo=rollno;
    }
    public String getmName(){ return mName;}
    public String getmCourse(){ return mCourse;}
    public int getmRollNo(){ return mRollNo;}

}
