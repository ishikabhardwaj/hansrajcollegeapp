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


public class TeacherAttendance extends Fragment {
    String subject, type,text;
    TextView h1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_upload_attendance, container, false);
        h1 = root.findViewById(R.id.header);
        final ArrayList<TeacherUploadAttendance> words= new ArrayList<TeacherUploadAttendance>();
        words.add(new TeacherUploadAttendance("Vardha Jain","B.Sc(Hons.) Computer Science",8151));
        words.add(new TeacherUploadAttendance("Harshit Jaiswal","B.Sc(Hons.) Computer Science",8152));
        words.add(new TeacherUploadAttendance("Monika Joshi","B.Sc(Hons.) Computer Science",8153));
        words.add(new TeacherUploadAttendance("Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",8154));
        words.add(new TeacherUploadAttendance("Priyanka Das","B.Sc(Hons.) Computer Science",8155));
        words.add(new TeacherUploadAttendance("Mamidi Chandu","B.Sc(Hons.) Computer Science",8157));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        words.add(new TeacherUploadAttendance("Benika Yadav","B.Sc(Hons.) Computer Science",8158));
        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        type= bundle.getString("Month_Selected");
        h1.setText(subject +" Attendance for Month " + type);
        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(new RecyclerAdapterForUploadAtt(words));
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(list.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.vertical_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        list.addItemDecoration(horizontalDecoration);
        return root;
    }

}