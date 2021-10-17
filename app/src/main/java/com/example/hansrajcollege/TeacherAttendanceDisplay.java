package com.example.hansrajcollege;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherAttendanceDisplay extends Fragment {
    TextView h1;
    String subject, month,text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.teacher_attendance_display, container, false);
        h1 = root.findViewById(R.id.textView_mark);

        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        month= bundle.getString("Month_Selected");
        h1.setText(subject +" Attendance for " + month);
        /*  Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
         */
        final ArrayList<AttendanceClass> words= new ArrayList<AttendanceClass>();
        AttendanceClass.mGiven=20;
        words.add(new AttendanceClass(8151 ,"Vardha Jain","B.Sc(Hons.) Computer Science",9));
        words.add(new AttendanceClass(8152,"Harshit Jaiswal","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8153,"Monika Joshi","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8155,"Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8157,"Priyanka Das","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8158,"Mamidi Chandu","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8159,"Benika Yadav","B.Sc(Hons.) Computer Science",10));
        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(new RecyclerAdapterForAttendanceView(words));
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(list.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.vertical_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        list.addItemDecoration(horizontalDecoration);
        return root;
    }
}
