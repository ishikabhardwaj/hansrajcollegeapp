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


public class TeacherMarksUpload extends Fragment {
    String subject, type,text;
    TextView h1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.teacher_upload_marks, container, false);
        h1 = root.findViewById(R.id.header);
        final ArrayList<TeacherUploadMarksClass> words= new ArrayList<TeacherUploadMarksClass>();
        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        type= bundle.getString("Type_Selected");
        h1.setText(subject +" Marks for " + type);
        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(new RecyclerAdapterForUploadMarks(words));
        words.add(new TeacherUploadMarksClass(8151 ,"Vardha Jain","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8152,"Harshit Jaiswal","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8153,"Monika Joshi","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8155,"Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8157,"Priyanka Das","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8158,"Mamidi Chandu","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8159,"Benika Yadav","B.Sc(Hons.) Computer Science",type));
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(list.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.vertical_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        list.addItemDecoration(horizontalDecoration);
        return root;
    }

}