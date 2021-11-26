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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hans.hansrajcollege.models.ApiClient;
import com.hans.hansrajcollege.models.UploadStudentMarksRequest;
import com.hans.hansrajcollege.models.student_details;
import com.hans.hansrajcollege.models.studentlist_request;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherMarksUpload extends Fragment {
    String subject, type,text;
    int Subject_id;
    FloatingActionButton save;
    TextView h1;
    RecyclerAdapterForUploadMarks recyclerAdapterForUploadMarks;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.teacher_upload_marks, container, false);
        h1 = root.findViewById(R.id.header);
        save=(FloatingActionButton)root.findViewById(R.id.fab);
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
                        list.setItemViewCacheSize(response.body().size());
                        recyclerAdapterForUploadMarks=new RecyclerAdapterForUploadMarks(UploadMarks);
                        list.setAdapter(recyclerAdapterForUploadMarks);

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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UploadStudentMarksRequest uploadStudentMarksRequest = new UploadStudentMarksRequest();

                String field=" ";
                int marks=0;


                if(type.startsWith("A")){
                    field="a"+type.substring(type.length()-1);
                    marks=10;

                }
                if(type.startsWith("I")){
                    field="i"+type.substring(type.length()-1);
                    marks=25;
                }
                Log.d("TYPE",field);
                uploadStudentMarksRequest.setField(field);


                uploadStudentMarksRequest.setSubject_id(Subject_id);
                uploadStudentMarksRequest.setTotal_marks(marks);
                String[] arrayList = recyclerAdapterForUploadMarks.retrieveData();
                Log.d("main log", String.valueOf(arrayList.length));


                JsonArray array = new JsonArray();
                for (int i = 0; i < arrayList.length; i++) {
                    try {
                        array.add(getatt(UploadMarks.get(i).getmRollno(), Integer.parseInt(arrayList[i])));
                        //array.put(words.get(1).getmRollNo(),arrayList.get(i).getAttendance());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


                Log.d("String: ",array.toString());
                uploadStudentMarksRequest.setData(array.toString());


                Call<UploadStudentMarksResponse> mark=ApiClient.getUserService(pref.getString("access", null)).upload_marks(uploadStudentMarksRequest);
                mark.enqueue(new Callback<UploadStudentMarksResponse>() {
                    @Override
                    public void onResponse(Call<UploadStudentMarksResponse> call, Response<UploadStudentMarksResponse> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(),"Marks Uploaded Successfully",Toast.LENGTH_LONG).show();
                            Log.d("response",response.body().getMessage());
                        }
                        else {
                            Toast.makeText(getContext(),"Failed to Upload the Marks",Toast.LENGTH_LONG).show();
                            Log.d("failed",response.toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<UploadStudentMarksResponse> call, Throwable t) {
                        Toast.makeText(getContext(),"Couldn't Upload Marks",Toast.LENGTH_LONG).show();
                        Log.d("False",t.getLocalizedMessage());
                    }
                });


            }
        });


        return root;


    }

    JsonObject getatt(int st_id, int attendance) throws JSONException {
        JSONObject person = new JSONObject();
        person .put("sid", st_id);
        person .put("marks", attendance);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(person.toString());


        return jsonObject ;
    }

}