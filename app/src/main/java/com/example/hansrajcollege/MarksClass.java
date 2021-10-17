package com.example.hansrajcollege;

public class MarksClass {
    private int mRollno;
    private String mName;
    private String mCourse;
    private int mMarks;
    private String testnumber;
    public MarksClass(int rollno,String name,String Course,int marks,String num){
        mRollno=rollno;
        mName=name;
        mCourse=Course;
        mMarks=marks;
        testnumber=num;
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
