package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.hansrajcollege.R;
import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.UploadStudentAttendanceRequest;
import com.example.hansrajcollege.models.UploadStudentAttendanceResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateAttendance extends Fragment {
   EditText rollno,att;
  Button update;
    String subject, month;
    int subject_id,total_tt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_update_attendance, container, false);
       update = (Button) root.findViewById(R.id.buttonforupdate);
       rollno = (EditText) root.findViewById(R.id.rollno);
       att = (EditText) root.findViewById(R.id.newatt);

       SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
       Bundle bundle= this.getArguments();
       subject= bundle.getString("Subject_Selected");
       month= bundle.getString("Month_Selected");
       subject_id=bundle.getInt("selected_sub_id");
       total_tt=bundle.getInt("total_attendance");



       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             // getFragmentManager().popBackStack();
               Log.d("Month",month);
               Log.d("Subject",subject);
               Log.d("subject_id", String.valueOf(subject_id));
               Log.d("total_tt", String.valueOf(total_tt));
               Log.d("Roll no", rollno.getText().toString());
               Log.d("Attendance", att.getText().toString());

               UploadStudentAttendanceRequest uploadStudentAttendanceRequest = new UploadStudentAttendanceRequest();
               uploadStudentAttendanceRequest.setMonth(month);
               uploadStudentAttendanceRequest.setSubject_id(subject_id);
               uploadStudentAttendanceRequest.setTotal_lectures(total_tt);

               JsonArray array = new JsonArray();

               try {
                   array.add(getatt(Integer.parseInt(rollno.getText().toString()), Integer.parseInt(att.getText().toString())));
                   //array.put(words.get(1).getmRollNo(),arrayList.get(i).getAttendance());
               } catch (JSONException e) {
                   e.printStackTrace();
               }
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
