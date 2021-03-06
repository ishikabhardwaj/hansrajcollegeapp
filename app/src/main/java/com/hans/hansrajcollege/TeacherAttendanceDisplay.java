package com.hans.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hans.hansrajcollege.models.ApiClient;
import com.hans.hansrajcollege.models.StudentAttendanceRequest;
import com.hans.hansrajcollege.models.StudentAttendanceResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherAttendanceDisplay extends Fragment {
    TextView h1;
    String subject, month,text;
    int subject_id;
    FloatingActionButton update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.teacher_attendance_display, container, false);
        h1 = root.findViewById(R.id.header);
        update = (FloatingActionButton) root.findViewById(R.id.update);

        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        month= bundle.getString("Month_Selected");
        subject_id=bundle.getInt("selected_sub_id");
        h1.setText(subject +" Attendance for " + month);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new UpdateAttendance();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        final ArrayList<AttendanceClass> words= new ArrayList<AttendanceClass>();
        //building request
        StudentAttendanceRequest studentAttendanceRequest=new StudentAttendanceRequest();
        studentAttendanceRequest.setSubject_id(subject_id);
        studentAttendanceRequest.setMonth(month);

        //Toast.makeText(getActivity(),subject_id+month,Toast.LENGTH_LONG).show();

        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));

        //sending request
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        Log.d("token",pref.getString("access",null));
        Call<List<StudentAttendanceResponse>> populate= ApiClient.getUserService(pref.getString("access",null)).student_attendance(studentAttendanceRequest);
        populate.enqueue(new Callback<List<StudentAttendanceResponse>>() {
            @Override
            public void onResponse(Call<List<StudentAttendanceResponse>> call, Response<List<StudentAttendanceResponse>> response) {
                if(response.isSuccessful()){
                    Log.d("list",response.body().get(1).toString());
                    for (int i=1;i<response.body().size();i++){
                        words.add(new AttendanceClass(response.body().get(i).getRollNo(),
                                response.body().get(i).getName(),
                                response.body().get(i).getCourse(),
                                response.body().get(i).getAttendance(),
                                response.body().get(0).getTotal_attendance()));
                    }
                    //AttendanceClass.mGiven=response.body().get(0).getTotal_attendance();
                    bundle.putInt("total_attendance",response.body().get(0).getTotal_attendance());
                    list.setAdapter(new RecyclerAdapterForAttendanceView(words));


                }
                else{
                    Toast.makeText(getActivity(),"Data is not available",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<StudentAttendanceResponse>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });
        //AttendanceClass.mGiven=20;
        /*words.add(new AttendanceClass(8151 ,"Vardha Jain","B.Sc(Hons.) Computer Science",9));
        words.add(new AttendanceClass(8152,"Harshit Jaiswal","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8153,"Monika Joshi","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8155,"Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8157,"Priyanka Das","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8158,"Mamidi Chandu","B.Sc(Hons.) Computer Science",10));
        words.add(new AttendanceClass(8159,"Benika Yadav","B.Sc(Hons.) Computer Science",10));*/

        return root;
    }
}
