package com.hans.hansrajcollege;

public class TeacherUploadMarksClass {
    private int mRollno;
    private String mName;
    private String mCourse;
    private int mMarks;
    private String testnumber;
    public TeacherUploadMarksClass(int rollno, String name,String course, String num){
        mRollno=rollno;
        mName=name;
        testnumber=num;
        mCourse=course;
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

    public int getmMarks() {
        return mMarks;
    }

    public String getTestnumber() {
        return testnumber;
    }
}
