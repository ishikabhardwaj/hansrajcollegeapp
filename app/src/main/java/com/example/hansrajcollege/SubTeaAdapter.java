package com.example.hansrajcollege;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SubTeaAdapter extends BaseAdapter {
    Context context;
    ArrayList<SubjectTeacher> w;
    LayoutInflater inflter;
    int ccid;
    Time ob;
    public SubTeaAdapter(Context applicationContext, ArrayList<SubjectTeacher> w, int cid) {
        this.context = context;
        this.w=w;
        ccid=cid;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return w.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int in, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview_subject_teacher, null);
       LinearLayout l1=(LinearLayout) view.findViewById(R.id.ll);
       LinearLayout l2=(LinearLayout) view.findViewById(R.id.ll2);
        TextView t1 = (TextView) view.findViewById(R.id.textView2);
        TextView t2 = (TextView) view.findViewById(R.id.textView1);
        TextView t3=(TextView) view.findViewById(R.id.textView3);
        t1.setText(w.get(in).getmSubject());
        t2.setText(w.get(in).getmTeacher());
        t3.setText(w.get(in).getmTMail());
        return view;
    }
}


