package com.example.hansrajcollege;

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

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.UploadStudentAttendanceRequest;
import com.example.hansrajcollege.models.att;
import com.example.hansrajcollege.models.student_details;
import com.example.hansrajcollege.models.studentlist_request;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherAttendance extends Fragment {
    String subject, type, text;
    int Subject_id,total_attendance;
    TextView h1;
    FloatingActionButton save;
    RecyclerAdapterForUploadAtt recyclerAdapterForUploadAtt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_upload_attendance, container, false);
        h1 = root.findViewById(R.id.header);
        save = (FloatingActionButton) root.findViewById(R.id.fab);
        final ArrayList<TeacherUploadAttendance> words = new ArrayList<TeacherUploadAttendance>();
        Bundle bundle = this.getArguments();
        subject = bundle.getString("Subject_Selected");
        type = bundle.getString("Month_Selected");
        Subject_id = bundle.getInt("subject_id");
        total_attendance=bundle.getInt("total_attendance");
        Log.d("subj_id", String.valueOf(Subject_id));
        h1.setText(subject + " Attendance for Month " + type);

        RecyclerView list = (RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
       // list.setAdapter(new RecyclerAdapterForUploadAtt(words));

        //Toast.makeText(getActivity(),String.valueOf(Subject_id),Toast.LENGTH_LONG).show();
        SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        //sending request
        studentlist_request studentlist_request = new studentlist_request();
        studentlist_request.setSubject_id(Subject_id);

        Call<List<student_details>> populate = ApiClient.getUserService(pref.getString("access", null)).student_list(studentlist_request);
        populate.enqueue(new Callback<List<student_details>>() {
            @Override
            public void onResponse(Call<List<student_details>> call, Response<List<student_details>> response) {
                if (response.isSuccessful()) {

                    if (response.body().size() == 0) {
                        Toast.makeText(getActivity(), "data is not available", Toast.LENGTH_LONG).show();
                    }

                    for (int i = 0; i < response.body().size(); i++) {
                        words.add(new TeacherUploadAttendance(
                                response.body().get(i).getName(),
                                response.body().get(i).getCourse(),
                                Integer.parseInt(response.body().get(i).getSid())
                                )
                        );

                        list.setItemViewCacheSize(words.size());
                        recyclerAdapterForUploadAtt = new RecyclerAdapterForUploadAtt(words);
                        //list.setAdapter(new RecyclerAdapterForUploadAtt(words));
                        list.setAdapter(recyclerAdapterForUploadAtt);


                    }
                } else {
                    Toast.makeText(getActivity(), "Data is not available", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<student_details>> call, Throwable t) {
                Log.d("ERROR", t.getLocalizedMessage());
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String month="";
                UploadStudentAttendanceRequest uploadStudentAttendanceRequest = new UploadStudentAttendanceRequest();
                if (type=="January"){
                    month="m1";
                }
                else if (type=="February"){
                    month="m2";
                }
                else if (type=="March"){
                    month="m3";
                }else if (type=="April"){
                    month="m4";
                }else if (type=="May"){
                    month="m5";
                }else if (type=="June"){
                    month="m6";
                }else if (type=="July"){
                    month="m7";
                }else if (type=="August"){
                    month="m8";
                }else if (type=="September"){
                    month="m9";
                }else if (type=="October"){
                    month="m10";
                }else if (type=="November"){
                    month="m11";
                }else if (type=="December"){
                    month="m12";
                }

                uploadStudentAttendanceRequest.setMonth(month);
                uploadStudentAttendanceRequest.setSubject_id(Subject_id);
                uploadStudentAttendanceRequest.setTotal_lectures(total_attendance);
               // ArrayList<att> arrayList = recyclerAdapterForUploadAtt.retrieveData();
                String[] arrayList = recyclerAdapterForUploadAtt.retrieveData();
                Log.d("main log", String.valueOf(arrayList.length));

                    JsonArray array = new JsonArray();
                    for (int i = 0; i < arrayList.length; i++) {
                    try {
                        array.add(getatt(words.get(i).getmRollNo(), Integer.parseInt(arrayList[i])));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                Log.d("String: ",array.toString());
                uploadStudentAttendanceRequest.setData(array.toString());
                Call<UploadStudentAttendanceResponse> atten = ApiClient.getUserService(pref.getString("access", null)).upload_attendance(uploadStudentAttendanceRequest);
                atten.enqueue(new Callback<UploadStudentAttendanceResponse>() {
                    @Override
                    public void onResponse(Call<UploadStudentAttendanceResponse> call, Response<UploadStudentAttendanceResponse> response) {
                        if(response.isSuccessful()){
                            Log.d("response",response.body().getMessage());
                        }
                        else {
                            Log.d("failed",response.toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<UploadStudentAttendanceResponse> call, Throwable t) {
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
        person .put("attendance", attendance);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(person.toString());
        return jsonObject ;
    }
}