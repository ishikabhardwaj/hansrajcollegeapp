package com.example.hansrajcollege;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hansrajcollege.models.att;

import java.util.ArrayList;

public class RecyclerAdapterForUploadAtt extends RecyclerView.Adapter<RecyclerAdapterForUploadAtt.ViewHolder> {
   private ArrayList<TeacherUploadAttendance> data;
     ArrayList<att> att_data;
     public String[] strings;

    // RecyclerView recyclerView;
    public RecyclerAdapterForUploadAtt(ArrayList<TeacherUploadAttendance> data) {
        this.data = data;
        Log.d("size data", String.valueOf(this.data.size()));
        strings=new String[data.size()];
        Log.d("size string", String.valueOf(strings.length));
        for (int i =0;i<data.size();++i){ strings[i]=""; }
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //att_data= new ArrayList<att>(data.size());
        //for (int i =0;i<data.size();++i){ att_data.add(new att(" ")); }

        Log.d("List size viewholder", String.valueOf(strings.length));
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_listview_attendance_upload, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TeacherUploadAttendance myListData = data.get(position);
        EditText att=holder.editText;
        att.setText(strings[holder.getAdapterPosition()]);
        Log.d("pop", strings[holder.getAdapterPosition()]);
        holder.textView1.setText(myListData.getmName());
        holder.textview2.setText(myListData.getmCourse());
        int roll = myListData.getmRollNo();
        String r = Integer.toString(roll);
        holder.textview3.setText(r);


        att.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              try {
                  //Log.d("on text chance", String.valueOf(strings.length));

                  //att_data.get(position).attendance=s.toString();
                  strings[position] = s.toString();
              } catch (Exception e) {
                  Log.d("error",e.getMessage());
              }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

   /* public ArrayList<att> retrieveData()
    {
        return att_data;
    }*/
    public String[] retrieveData()
    {
        return strings;
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


