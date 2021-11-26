package com.hans.hansrajcollege;

public class MarksClassforStudent {
    private String testnumber,mMarks;
    public MarksClassforStudent(String testnum, String marks){
        testnumber=testnum;
        mMarks=marks;
    }
    public String getmMarks() {
        return mMarks;
    }

    public String getTestnumber() {
        return testnumber;
    }

}
