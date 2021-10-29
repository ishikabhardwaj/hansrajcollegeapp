package com.example.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.hansrajcollege.R;

public class UpdateAttendance extends Fragment {
   EditText rollno,att;
  Button update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_update_attendance, container, false);
       update = (Button) root.findViewById(R.id.buttonforupdate);
       rollno = (EditText) root.findViewById(R.id.rollno);
       att = (EditText) root.findViewById(R.id.newatt);
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              getFragmentManager().popBackStack();
           }
       });







        return root;
    }
}
