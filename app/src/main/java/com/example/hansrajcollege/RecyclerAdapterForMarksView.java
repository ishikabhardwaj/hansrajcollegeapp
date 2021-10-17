package com.example.hansrajcollege;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterForMarksView extends RecyclerView.Adapter<RecyclerAdapterForMarksView.ViewHolder> {
   private ArrayList<MarksClass> data;

    // RecyclerView recyclerView;
    public RecyclerAdapterForMarksView(ArrayList<MarksClass> data) {
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_listview_list_of_marks, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MarksClass myListData = data.get(position);
        holder.textviewname.setText(myListData.getmName());
        holder.textviewcourse.setText(myListData.getmCourse());
        int roll=myListData.getmRollno();
        String r=Integer.toString(roll);
        holder.textViewrollno.setText(r);
        if(myListData.getTestnumber()=="Assignment 1" || myListData.getTestnumber()=="Assignment 2" || myListData.getTestnumber()=="Assignment 3" || myListData.getTestnumber()=="Assignment 4" || myListData.getTestnumber()=="Assignment 5"){
            holder.textviewmarks.setText(myListData.getmMarks() + " / 10");
        }
        else
        {
            holder.textviewmarks.setText(myListData.getmMarks() + " / 25");
        }

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewrollno,textviewname,textviewcourse,textviewmarks;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewrollno = (TextView) itemView.findViewById(R.id.textViewrollno);
            this.textviewname = (TextView) itemView.findViewById(R.id.textViewName);
            this.textviewcourse = (TextView) itemView.findViewById(R.id.textViewCourse);
            this.textviewmarks = (TextView) itemView.findViewById(R.id.textViewmarks);
        }
    }
}


