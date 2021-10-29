package com.example.hansrajcollege.models;

public class MarksClassforStudent {
    static int mMarks;
    private String testnumber;
    public MarksClassforStudent(String testnum, int marks){
        testnumber=testnum;
        mMarks=marks;
    }
    public int getmMarks() {
        return mMarks;
    }

    public String getTestnumber() {
        return testnumber;
    }
}
