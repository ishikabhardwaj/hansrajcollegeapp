package com.example.hansrajcollege;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Student_Attendance_Adapter extends BaseAdapter {
    Context context;
    ArrayList<StudentAttendance> w;
    LayoutInflater inflter;
    int ccid;
    Time ob;
    public Student_Attendance_Adapter(Context applicationContext, ArrayList<StudentAttendance> w, int cid) {
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
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflter.inflate(R.layout.activity_listview_attendance,null);
        TextView t1=(TextView)convertView.findViewById(R.id.textView2);
        TextView t2=(TextView)convertView.findViewById(R.id.textView0);
        TextView t3=(TextView)convertView.findViewById(R.id.textView1);
        TextView t4=(TextView)convertView.findViewById(R.id.textView3);

        t1.setText(w.get(position).getMSubject());
        t3.setText(w.get(position).getMAttendance());
        t4.setText(w.get(position).getMPercentage());
        return convertView;
    }
}
