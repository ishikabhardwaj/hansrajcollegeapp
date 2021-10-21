package com.example.hansrajcollege;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterForUploadMarks extends RecyclerView.Adapter<RecyclerAdapterForUploadMarks.ViewHolder> {
   private ArrayList<TeacherUploadMarksClass> data;

    // RecyclerView recyclerView;
    public RecyclerAdapterForUploadMarks(ArrayList<TeacherUploadMarksClass> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_listview_marks_upload, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TeacherUploadMarksClass myListData = data.get(position);
        holder.textView1.setText(myListData.getmName());
        holder.textview2.setText(myListData.getmCourse());
        int roll = myListData.getmRollno();
        String r = Integer.toString(roll);
        holder.textview3.setText(r);
        if(myListData.getTestnumber().equals("Assignment 1") || myListData.getTestnumber().equals("Assignment 2") || myListData.getTestnumber().equals("Assignment 3") || myListData.getTestnumber().equals("Assignment 4") || myListData.getTestnumber().equals("Assignment 5")){
            holder.textview4.setText("/10");
        }
        else
        {
            holder.textview4.setText( "/25");
        }
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
           this.textview4= (TextView) itemView.findViewById(R.id.MaxMarks);
        }
    }
}


