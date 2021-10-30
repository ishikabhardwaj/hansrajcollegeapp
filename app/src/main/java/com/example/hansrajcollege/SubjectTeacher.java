package com.example.hansrajcollege;

import androidx.annotation.Nullable;

public class SubjectTeacher {

    private String mSubject;
    private String mTeacher1;
    private String mTMail1;
    private String mTeacher2;
    private String mTMail2;
    public SubjectTeacher(String subject, String teacher1,String mail1,String teacher2 ,String mail2)
    {
        mSubject=subject;
        mTeacher1=teacher1;
        mTMail1=mail1;
        mTeacher2= teacher2;
        mTMail2 = mail2;
    }
    public String getmSubject(){ return mSubject;}
    public String getmTeacher1(){ return mTeacher1;}
    public String getmTMail1(){ return mTMail1;}

    public String getmTeacher2() {
        return mTeacher2;
    }

    public String getmTMail2() {
        return mTMail2;
    }
}
