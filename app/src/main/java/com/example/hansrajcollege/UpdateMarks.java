package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.StudentMarksRequest;
import com.example.hansrajcollege.models.StudentMarksResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateMarks extends Fragment {
   EditText rollno,marks;
  Button update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_update_marks, container, false);
       update = (Button) root.findViewById(R.id.buttonforupdate);
       rollno = (EditText) root.findViewById(R.id.rollno);
       marks = (EditText) root.findViewById(R.id.newmarks);
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              getFragmentManager().popBackStack();
           }
       });







        return root;
    }
}
