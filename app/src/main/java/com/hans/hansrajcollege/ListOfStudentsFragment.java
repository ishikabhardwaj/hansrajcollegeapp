package com.hans.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hans.hansrajcollege.models.ApiClient;
import com.hans.hansrajcollege.models.student_details;
import com.hans.hansrajcollege.models.studentlist_request;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListOfStudentsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        View root=inflater.inflate(R.layout.fragment_list_of_students, container, false);
        final ArrayList<StudentAttendanceClass> words= new ArrayList<StudentAttendanceClass>();

        studentlist_request studentlist_request=new studentlist_request();
        studentlist_request.setSubject_id(pref.getInt("selected_sub",6));

        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<List<student_details>> populate= ApiClient.getUserService(pref.getString("access",null)).student_list(studentlist_request);
        populate.enqueue(new Callback<List<student_details>>() {
            @Override
            public void onResponse(Call<List<student_details>> call, Response<List<student_details>> response) {
                    if (response.isSuccessful()) {

                        if (response.body().size() == 0) {
                            Toast.makeText(getActivity(), "data is not available", Toast.LENGTH_LONG).show();
                        } else {
                            for (int i = 0; i < response.body().size(); i++) {
                                words.add(new StudentAttendanceClass(
                                        response.body().get(i).getName(),
                                        response.body().get(i).getCourse(),
                                        Integer.parseInt(response.body().get(i).getSid()),
                                        response.body().get(i).getEmail()
                                ));
                                list.setAdapter(new RecyclerAdapter(words));

                            }
                        }
                    }
                    else {
                        Toast.makeText(getActivity(), "Data is not available", Toast.LENGTH_LONG).show();
                    }
                }
            @Override
            public void onFailure(Call<List<student_details>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });




       // words.add(new StudentAttendanceClass("Vardha Jain","B.Sc(Hons.) Computer Science",8151,"vardha@gmail.com"));
        //words.add(new StudentAttendanceClass("Harshit Jaiswal","B.Sc(Hons.) Computer Science",8152,"harshit@gmail.com"));
       // words.add(new StudentAttendanceClass("Monika Joshi","B.Sc(Hons.) Computer Science",8153,"monika@gmail.com"));
        //words.add(new StudentAttendanceClass("Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",8154,"hemant@gmail.com"));
        //words.add(new StudentAttendanceClass("Priyanka Das","B.Sc(Hons.) Computer Science",8155,"priyanka@gmail.com"));
        //words.add(new StudentAttendanceClass("Mamidi Chandu","B.Sc(Hons.) Computer Science",8157,"mamidi@gmail.com"));
        //words.add(new StudentAttendanceClass("Benika Yadav","B.Sc(Hons.) Computer Science",8158,"benika@gmail.com"));

        return root;
    }

}