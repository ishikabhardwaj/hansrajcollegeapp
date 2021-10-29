package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.Subject_Teacher_Details_Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SubjectTeacherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
            View root=inflater.inflate(R.layout.fragment_subjects_teachers, container, false);

            final ArrayList<SubjectTeacher> words= new ArrayList<SubjectTeacher>();

            ListView list= (ListView) root.findViewById(R.id.list);
            Call<List<Subject_Teacher_Details_Response>> populate= ApiClient.getUserService(pref.getString("access",null)).SUBJECT_TEACHER_DETAILS_RESPONSE_CALL();
            populate.enqueue(new Callback<List<Subject_Teacher_Details_Response>>() {
                @Override
                public void onResponse(Call<List<Subject_Teacher_Details_Response>> call, Response<List<Subject_Teacher_Details_Response>> response) {
                    if(response.isSuccessful()){
                        if(response.body().size()==0){
                            Toast.makeText(getActivity(), "data is not available", Toast.LENGTH_LONG).show();
                        }
                        else{
                            for(int i=0;i<response.body().size();i++){
                               /* if(response.body().get(i).getTeacher().contains(",")){
                                    int comma_in_teacher_names=response.body().get(i).getTeacher().indexOf(',');
                                    int comma_in_email=response.body().get(i).getEmail().indexOf(',');
                                    String teacher1=response.body().get(i).getTeacher().substring(0,comma_in_teacher_names-1);
                                    String teacher2=response.body().get(i).getTeacher().substring(comma_in_teacher_names+1,response.body().get(i).getTeacher().length()-1);
                                    String mail1=response.body().get(i).getEmail().substring(0,comma_in_email-1);
                                    String mail2=response.body().get(i).getTeacher().substring(comma_in_email+1,response.body().get(i).getEmail().length()-1);

                                }*/
                                //else{
                                    //show null in place of teacher 2 and mail2
                                    words.add(new SubjectTeacher(response.body().get(i).getSubject(),
                                            response.body().get(i).getTeacher(),
                                            response.body().get(i).getEmail()));
                               // }

                            }
                            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    SubjectTeacher word= words.get(position);
                                }

                            });
                            SubTeaAdapter customAdapter = new SubTeaAdapter(getActivity(), words,3);
                            list.setAdapter(customAdapter);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Subject_Teacher_Details_Response>> call, Throwable t) {
                    Log.d("ERROR",t.getLocalizedMessage());
                }
            });
            return root;
        }
    }
