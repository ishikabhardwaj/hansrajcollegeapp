package com.example.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ThursdayFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_thursday, container, false);
        final ArrayList<Time> words= new ArrayList<Time>();
        words.add(new Time("DSE-1 Lab","Manju Sardana,Alka Khurana","8:40-9:40"));
        words.add(new Time("DSE-1 Lab","Manju Sardana,Alka Khurana","9:40-10:40"));
        words.add(new Time("DSE-1","Manju Sardana","10:40-11:40"));
        words.add(new Time("NILL","NILL","11:40-12:40"));
        words.add(new Time("Break","Take Rest","12:40-1:00"));
        words.add(new Time("IT-Lab","Sunita Chand, Aarti Goel","1:00-2:00"));
        words.add(new Time("IT-Lab","Sunita Chand, Aarti Goel","2:00-3:00"));

        ListView list= (ListView) root.findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Time time= words.get(position);
            }

        });
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), words,3);
        list.setAdapter(customAdapter);
        return root;
    }
}