package com.hans.hansrajcollege;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Time> w;
    LayoutInflater inflter;
    int ccid;
    Time ob;
    public CustomAdapter(Context applicationContext, ArrayList<Time> w, int cid) {
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
        view = inflter.inflate(R.layout.activity_listview, null);
       LinearLayout l1=(LinearLayout) view.findViewById(R.id.ll);
       LinearLayout l2=(LinearLayout) view.findViewById(R.id.ll2);
        TextView t1 = (TextView) view.findViewById(R.id.textView2);
        TextView t2 = (TextView) view.findViewById(R.id.textView1);
        TextView t3=(TextView) view.findViewById(R.id.time);
        ImageView i1=(ImageView) view.findViewById(R.id.image1);
        ImageView i2=(ImageView) view.findViewById(R.id.image3);
        t1.setText(w.get(in).getmSubject());
        t2.setText(w.get(in).getmTeacher());
        t3.setText(w.get(in).getMtiming());
        if(w.get(in).getMtiming()=="12:40-1:00"){
            i1.setVisibility(View.INVISIBLE);
            i2.setVisibility(View.INVISIBLE);
            t1.setTextSize(20);
            t1.setGravity(1);
            t2.setVisibility(View.INVISIBLE);
            t1.setPadding(0,50,0,0);
        }
        if(w.get(in).getmSubject()=="NILL"){
            i1.setVisibility(View.INVISIBLE);
            i2.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            t1.setText("----");
            t1.setPadding(10,30,10,10);
        }
        return view;
    }
}


