package com.example.hansrajcollege;

public class SubjectTeacher {

    private String mSubject;
    private String mTeacher;
    private String mTMail;
    public SubjectTeacher(String subject, String teacher,String mail)
    {
        mSubject=subject;
        mTeacher=teacher;
        mTMail=mail;
    }
    public String getmSubject(){ return mSubject;}
    public String getmTeacher(){ return mTeacher;}
    public String getmTMail(){ return mTMail;}

}
