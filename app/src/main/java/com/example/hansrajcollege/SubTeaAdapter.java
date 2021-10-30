package com.example.hansrajcollege;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
        LinearLayout l1=(LinearLayout) view.findViewById(R.id.unfixed);
        TextView t1 = (TextView) view.findViewById(R.id.textView2);
        TextView t2 = (TextView) view.findViewById(R.id.textView1);
        TextView t3=(TextView) view.findViewById(R.id.textView3);
        TextView t4 = (TextView) view.findViewById(R.id.textViewsecondteacher);
        TextView t5 = (TextView) view.findViewById(R.id.textViewsecondmail);
        if(w.get(in).getmTeacher2()=="NULL")
        {
            l1.setVisibility(View.INVISIBLE);
        }
        t1.setText(w.get(in).getmSubject());
        t2.setText(w.get(in).getmTeacher1());
        t3.setText(w.get(in).getmTMail1());
        t4.setText(w.get(in).getmTeacher2());
        t5.setText(w.get(in).getmTMail2());
        t3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",w.get(in).getmTMail1(), null));// only email apps should handle this

                if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                    v.getContext().startActivity(intent);}
                t3.setTextColor(R.color.yellow);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",w.get(in).getmTMail2(), null));// only email apps should handle this

                if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                    v.getContext().startActivity(intent);}
                t5.setTextColor(R.color.yellow);
            }
        });
        return view;
    }
}


