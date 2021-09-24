package com.example.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class AttendanceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_attendance, container, false);
        final ArrayList<StudentAttendance> words= new ArrayList<StudentAttendance>();
        String subject="DSA"; String month="August"; int TotalLectures=120; int AttendedLectures=60; //response from server
        String attendance=Integer.toString(AttendedLectures)+"/"+Integer.toString(TotalLectures);
        float percentage=((float) AttendedLectures/TotalLectures)*100;
        words.add(new StudentAttendance(subject,month,attendance,percentage));

        ListView attendance_List=(ListView)root.findViewById(R.id.attendance_list);
        attendance_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentAttendance SA=words.get(position);
            }
        });

        Student_Attendance_Adapter customAdapter=new Student_Attendance_Adapter(getActivity(),words,3);
        attendance_List.setAdapter(customAdapter);

        return root;
    }
}