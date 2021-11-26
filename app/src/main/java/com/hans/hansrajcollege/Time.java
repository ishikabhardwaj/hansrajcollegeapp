package com.hans.hansrajcollege;

public class Time {

    private String mSubject;
    private String mTeacher;
    private String mtiming;
    public Time(String subject, String teacher,String timing)
    {
        mSubject=subject;
        mTeacher=teacher;
        mtiming=timing;
    }
    public String getmSubject(){ return mSubject;}
    public String getmTeacher(){ return mTeacher;}
    public String getMtiming(){ return mtiming;}

}
