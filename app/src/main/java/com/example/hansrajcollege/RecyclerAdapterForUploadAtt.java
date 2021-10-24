package com.example.hansrajcollege;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterForUploadAtt extends RecyclerView.Adapter<RecyclerAdapterForUploadAtt.ViewHolder> {
   private ArrayList<TeacherUploadAttendance> data;

    // RecyclerView recyclerView;
    public RecyclerAdapterForUploadAtt(ArrayList<TeacherUploadAttendance> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_listview_attendance_upload, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TeacherUploadAttendance myListData = data.get(position);
        holder.textView1.setText(myListData.getmName());
        holder.textview2.setText(myListData.getmCourse());
        int roll = myListData.getmRollNo();
        String r = Integer.toString(roll);
        holder.textview3.setText(r);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1,textview2,textview3;
        public EditText editText;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView1 = (TextView) itemView.findViewById(R.id.textView2);
            this.textview2 = (TextView) itemView.findViewById(R.id.textView1);
            this.textview3 = (TextView) itemView.findViewById(R.id.textView3);
            this.editText=(EditText) itemView.findViewById(R.id.lectureedittext);

        }
    }

}


