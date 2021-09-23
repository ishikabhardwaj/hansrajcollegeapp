package com.example.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class SubjectTeacherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View root=inflater.inflate(R.layout.fragment_subjects_teachers, container, false);
            final ArrayList<SubjectTeacher> words= new ArrayList<SubjectTeacher>();
            words.add(new SubjectTeacher("Data Analysis and Visualiazation","Manju Sardana","Manju@Sardana"));
            words.add(new SubjectTeacher("Internet Technology","Sunita Chand","Sunita@Chand"));
            words.add(new SubjectTeacher("Theory Of Computation","Alka Khuranna","Alka@Khurana"));
            words.add(new SubjectTeacher("MicroProcessor","Suyash Kumar","Suyash@Kumar"));

            ListView list= (ListView) root.findViewById(R.id.list);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    SubjectTeacher word= words.get(position);
                }

            });
            SubTeaAdapter customAdapter = new SubTeaAdapter(getActivity(), words,3);
            list.setAdapter(customAdapter);
            return root;
        }
    }
