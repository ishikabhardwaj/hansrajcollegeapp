package com.example.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class StudentInformation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String Subjects[]={"Programming in Java","Android Development","Software Engineering","Microprocessor"};
            View root=inflater.inflate(R.layout.fragment_student_information, container, false);
            ListView list= (ListView) root.findViewById(R.id.list);
        ArrayAdapter<String> customAdapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_listview_subject, R.id.textView2,Subjects);
        list.setAdapter(customAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Fragment fragment = new ListOfStudentsFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            });
            return root;
        }
    }
