package com.hans.hansrajcollege;

import android.annotation.SuppressLint;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
   private ArrayList<StudentAttendanceClass> data;

    // RecyclerView recyclerView;
    public RecyclerAdapter(ArrayList<StudentAttendanceClass> data) {
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_listview_list_of_students, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final StudentAttendanceClass myListData = data.get(position);
        holder.textView1.setText(myListData.getmName());
        holder.textview2.setText(myListData.getmCourse());
        int roll=myListData.getmRollNo();
        String r=Integer.toString(roll);
        holder.textview3.setText(r);
        holder.textview4.setText(myListData.getmEmail());
        holder.textview4.setMovementMethod(LinkMovementMethod.getInstance());
        holder.textview4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",myListData.getmEmail(), null));// only email apps should handle this

                if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                    v.getContext().startActivity(intent);}
                holder.textview4.setTextColor(R.color.yellow);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1,textview2,textview3,textview4;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView1 = (TextView) itemView.findViewById(R.id.textView2);
            this.textview2 = (TextView) itemView.findViewById(R.id.textView1);
            this.textview3 = (TextView) itemView.findViewById(R.id.textView3);
            this.textview4 = (TextView) itemView.findViewById(R.id.textView8);
        }
    }
}


