package com.hans.hansrajcollege;

public class MarksClass {
    private int mRollno;
    private String mName;
    private String mCourse;
    private int mMarks;
    private String testnumber;
    public MarksClass(int rollno, String name, String course, int marks, String num){
        mRollno=rollno;
        mName=name;
        mMarks=marks;
        mCourse=course;
        testnumber=num;
    }
    public MarksClass(String testnum,int marks){
        testnumber=testnum;
        mMarks=marks;
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
