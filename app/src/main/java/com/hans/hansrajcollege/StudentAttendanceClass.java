package com.hans.hansrajcollege;

public class StudentAttendanceClass {

    private String mName;
    private String mCourse;
    private int mRollNo;
    private String mEmail;
    public StudentAttendanceClass(String name, String course, int rollno,String email)
    {
        mName=name;
        mCourse=course;
        mRollNo=rollno;
        mEmail=email;
    }
    public String getmName(){ return mName;}
    public String getmCourse(){ return mCourse;}
    public int getmRollNo(){ return mRollNo;}
    public String getmEmail(){ return mEmail;}

}
