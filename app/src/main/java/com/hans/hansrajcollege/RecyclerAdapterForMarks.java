package com.hans.hansrajcollege;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterForMarks extends RecyclerView.Adapter<RecyclerAdapterForMarks.ViewHolder> {
   private ArrayList<MarksClassforStudent> data;

    // RecyclerView recyclerView;
    public RecyclerAdapterForMarks(ArrayList<MarksClassforStudent> data) {
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_listview_list_of_marks_for_student, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MarksClassforStudent myListData = data.get(position);
        holder.textviewnumber.setText(myListData.getTestnumber());
       // int marks=myListData.getmMarks();
       // String mark=Integer.toString(marks);
       // if(myListData.getTestnumber()=="Assignment")
      //  holder.textviewmarks.setText(mark + "/10");
       // else
     holder.textviewmarks.setText(myListData.getmMarks());

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textviewnumber,textviewmarks;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textviewnumber = (TextView) itemView.findViewById(R.id.textViewNumber);
            this.textviewmarks = (TextView) itemView.findViewById(R.id.textViewmarks);
        }
    }
}


