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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.student_details;
import com.example.hansrajcollege.models.studentlist_request;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherMarksUpload extends Fragment {
    String subject, type,text;
    int Subject_id;
    TextView h1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.teacher_upload_marks, container, false);
        h1 = root.findViewById(R.id.header);
        final ArrayList<TeacherUploadMarksClass> UploadMarks= new ArrayList<TeacherUploadMarksClass>();

        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        type= bundle.getString("Type_Selected");
        Subject_id=bundle.getInt("Selected_Subject_Id");
        h1.setText(subject +" Marks for " + type);


        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(new RecyclerAdapterForUploadMarks(UploadMarks));

        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        //sending request
        studentlist_request studentlist_request=new studentlist_request();
        studentlist_request.setSubject_id(Subject_id);

        Call<List<student_details>> populate= ApiClient.getUserService(pref.getString("access",null)).student_list(studentlist_request);
        populate.enqueue(new Callback<List<student_details>>() {
            @Override
            public void onResponse(Call<List<student_details>> call, Response<List<student_details>> response) {
                if(response.isSuccessful()){

                    if(response.body().size()==0){
                        Toast.makeText(getActivity(),"data is not available",Toast.LENGTH_LONG).show();
                    }

                    for (int i=0;i<response.body().size();i++){
                        UploadMarks.add(new TeacherUploadMarksClass(
                                Integer.parseInt(response.body().get(i).getSid()),
                                response.body().get(i).getName(),
                                response.body().get(i).getCourse(),
                                type)

                        );
                        list.setAdapter(new RecyclerAdapterForUploadMarks(UploadMarks));

                    }
                }
                else{
                    Toast.makeText(getActivity(),"Data is not available",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<student_details>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });






        /*words.add(new TeacherUploadMarksClass(8151 ,"Vardha Jain","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8152,"Harshit Jaiswal","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8153,"Monika Joshi","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8155,"Hemant Giri Goshwami","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8157,"Priyanka Das","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8158,"Mamidi Chandu","B.Sc(Hons.) Computer Science",type));
        words.add(new TeacherUploadMarksClass(8159,"Benika Yadav","B.Sc(Hons.) Computer Science",type));*/

        return root;
    }

}