package com.example.hansrajcollege;

public class TeacherUploadAttendance {

    private String mName;
    private String mCourse;
    private int mRollNo;
    public String attendance;
    public TeacherUploadAttendance(String name, String course, int rollno)
    {
        mName=name;
        mCourse=course;
        mRollNo=rollno;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getmName(){ return mName;}
    public String getmCourse(){ return mCourse;}
    public int getmRollNo(){ return mRollNo;}

}
