package com.example.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ListOfStudentsFragment extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
CustomSpinner s;
String Months[]={"Month","January","February","March","April","May","June","July","August","Septemer","October","November","December"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_list_of_students, container, false);
        final ArrayList<StudentAttendanceClass> words= new ArrayList<StudentAttendanceClass>();
        words.add(new StudentAttendanceClass("Vardha Jain","B.Sc(Hons.) Computer Science",8151));
        words.add(new StudentAttendanceClass("Harshit Jaiswal","B.Sc(Hons.) Computer Science",8152));
        words.add(new StudentAttendanceClass("Monika Joshi","B.Sc(Hons.) Computer Science",8153));
        words.add(new StudentAttendanceClass("Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",8154));
        words.add(new StudentAttendanceClass("Priyanka Das","B.Sc(Hons.) Computer Science",8155));
        words.add(new StudentAttendanceClass("Mamidi Chandu","B.Sc(Hons.) Computer Science",8157));
        words.add(new StudentAttendanceClass("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        s = (CustomSpinner) root.findViewById(R.id.spinner5);
        s.setSpinnerEventsListener(this);
        ArrayAdapter aa = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Months);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(aa);
        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(new RecyclerAdapter(words));
        return root;
    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

    }
}