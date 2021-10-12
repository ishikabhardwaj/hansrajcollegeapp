package com.example.hansrajcollege;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterForAttendanceView extends RecyclerView.Adapter<RecyclerAdapterForAttendanceView.ViewHolder> {
   private ArrayList<AttendanceClass> data;

    // RecyclerView recyclerView;
    public RecyclerAdapterForAttendanceView(ArrayList<AttendanceClass> data) {
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_listview_list_of_attendace, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final AttendanceClass myListData = data.get(position);
        holder.textviewname.setText(myListData.getmName());
        holder.textviewcourse.setText(myListData.getmCourse());
        int roll=myListData.getmRollno();
        String r=Integer.toString(roll);
        holder.textViewrollno.setText(r);
            String att= myListData.getmAttended() + " / " + AttendanceClass.getmGiven();
        holder.textviewatt.setText(att);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewrollno,textviewname,textviewcourse,textviewatt;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewrollno = (TextView) itemView.findViewById(R.id.textViewrollno);
            this.textviewname = (TextView) itemView.findViewById(R.id.textViewName);
            this.textviewcourse = (TextView) itemView.findViewById(R.id.textViewCourse);
            this.textviewatt = (TextView) itemView.findViewById(R.id.textViewatt);
        }
    }
}


