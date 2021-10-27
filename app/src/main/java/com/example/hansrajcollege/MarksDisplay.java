package com.example.hansrajcollege;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hansrajcollege.models.MarksClassforStudent;
import com.example.hansrajcollege.models.RecyclerAdapterForMarks;

import java.util.ArrayList;


public class MarksDisplay extends Fragment {


    TextView h1, d1, m1;
    ImageView i1;
    String subject, type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.marksdisplay, container, false);
        h1 = root.findViewById(R.id.header);

        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        type= bundle.getString("Type_Selected");
       h1.setText(type + " Marks of " + subject);
        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ArrayList<MarksClassforStudent> words= new ArrayList<MarksClassforStudent>();
        words.add(new MarksClassforStudent(type,314));
        words.add(new MarksClassforStudent(type,11241));
        words.add(new MarksClassforStudent(type,1144));
        words.add(new MarksClassforStudent(type,1312));
        words.add(new MarksClassforStudent(type,14134));
        words.add(new MarksClassforStudent(type,1144));
        words.add(new MarksClassforStudent(type,1441));
        words.add(new MarksClassforStudent(type,132));
        list.setAdapter(new RecyclerAdapterForMarks(words));
        return root;
    }
}

