package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.StudentMarksRequest;
import com.example.hansrajcollege.models.StudentMarksResponse;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherMarksDisplay extends Fragment {
    TextView h1;
    String subject, type,text;
    int Subject_id;
  FloatingActionButton update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.teacher_marks_display, container, false);
        h1 = root.findViewById(R.id.header);
       update = (FloatingActionButton) root.findViewById(R.id.update);
        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        type= bundle.getString("Type_Selected");
        Subject_id=bundle.getInt("selected_subject_id");
        h1.setText(subject +" Marks for " + type);
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Fragment fragment = new UpdateMarks();
               fragment.setArguments(bundle);
               //getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.fragment_container, fragment);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();
           }
       });

        final ArrayList<MarksClass> words= new ArrayList<MarksClass>();

        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Building Request
        StudentMarksRequest studentMarksRequest=new StudentMarksRequest();
        studentMarksRequest.setSubject_id(Subject_id);
        studentMarksRequest.setField(type);
        //Toast.makeText(getActivity(),Subject_id+type,Toast.LENGTH_LONG).show();

        //sending request to get a response
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        Call<List<StudentMarksResponse>> populate= ApiClient.getUserService(pref.getString("access",null)).student_marks(studentMarksRequest);
        populate.enqueue(new Callback<List<StudentMarksResponse>>() {
            @Override
            public void onResponse(Call<List<StudentMarksResponse>> call, Response<List<StudentMarksResponse>> response) {
                if(response.isSuccessful()){
                    Log.d("list",response.body().get(1).getClass().toString());
                    for(int i=1;i<response.body().size();i++){
                        words.add(new MarksClass(response.body().get(i).getRollNo(),
                                response.body().get(i).getName(),
                                response.body().get(i).getCourse(),
                                response.body().get(i).getMarks(),
                                type));
                        Log.d("marks", String.valueOf(words.get(i-1).getmMarks()));
                    }
                    //MarksClass.mMarks=response.body().get(0).getTotal_marks();
                    //Log.d("Total Marks",String.valueOf(response.body().get(0).getTotal_marks()));
                    list.setAdapter(new RecyclerAdapterForMarksView(words));


                }
                else {
                    Toast.makeText(getActivity(),"Data is not available",Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<List<StudentMarksResponse>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });



       /* words.add(new MarksClass(8151 ,"Vardha Jain","B.Sc(Hons.) Computer Science",9,type));
        words.add(new MarksClass(8152,"Harshit Jaiswal","B.Sc(Hons.) Computer Science",10,type));
        words.add(new MarksClass(8153,"Monika Joshi","B.Sc(Hons.) Computer Science",10,type));
        words.add(new MarksClass(8155,"Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",10,type));
        words.add(new MarksClass(8157,"Priyanka Das","B.Sc(Hons.) Computer Science",10,type));
        words.add(new MarksClass(8158,"Mamidi Chandu","B.Sc(Hons.) Computer Science",10,type));
        words.add(new MarksClass(8159,"Benika Yadav","B.Sc(Hons.) Computer Science",10,type));*/


        return root;
    }
}
