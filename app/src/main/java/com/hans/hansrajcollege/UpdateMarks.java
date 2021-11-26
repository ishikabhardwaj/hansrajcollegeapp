package com.hans.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hans.hansrajcollege.models.ApiClient;
import com.hans.hansrajcollege.models.UploadStudentMarksRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateMarks extends Fragment {
   EditText rollno,marks;
    String subject, type;
    int Subject_id;
  Button update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_update_marks, container, false);
       update = (Button) root.findViewById(R.id.buttonforupdate);
       rollno = (EditText) root.findViewById(R.id.rollno);
       marks = (EditText) root.findViewById(R.id.newmarks);
       //UploadStudentMarksRequest uploadStudentMarksRequest = new UploadStudentMarksRequest();
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);

        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        type= bundle.getString("Type_Selected");
        Log.d("TYPE",type.toString());
        Log.d("subject",type.toString());
        Log.d("TYPE",type.toString());
        Subject_id=bundle.getInt("selected_subject_id");


        update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              //getFragmentManager().popBackStack();
               int mark=0;
               if(type.startsWith("a")){
                   mark=10;

               }
               if(type.startsWith("i")){
                   mark=25;
               }
               UploadStudentMarksRequest uploadStudentMarksRequest = new UploadStudentMarksRequest();
               uploadStudentMarksRequest.setField(type);
               uploadStudentMarksRequest.setSubject_id(Subject_id);
               uploadStudentMarksRequest.setTotal_marks(mark);
               JsonArray array = new JsonArray();
               try {
                   array.add(getatt(Integer.parseInt(rollno.getText().toString()),Integer.parseInt(marks.getText().toString())));
                   //array.put(words.get(1).getmRollNo(),arrayList.get(i).getAttendance());
               } catch (JSONException e) {
                   e.printStackTrace();
               }

               uploadStudentMarksRequest.setData(array.toString());
               try {


                   Call<UploadStudentMarksResponse> upda = ApiClient.getUserService(pref.getString("access", null)).upload_marks(uploadStudentMarksRequest);
                   upda.enqueue(new Callback<UploadStudentMarksResponse>() {
                       @Override
                       public void onResponse(Call<UploadStudentMarksResponse> call, Response<UploadStudentMarksResponse> response) {
                          if (response.isSuccessful()) {
                               Log.d("response", response.body().getMessage());
                               Toast.makeText(getContext(),"Marks Updated Successfully",Toast.LENGTH_LONG).show();
                         } else {
                              Toast.makeText(getContext(),"Failed to Update Marks",Toast.LENGTH_LONG).show();
                              Log.d("failed", response.toString());
                        }

                       }

                       @Override
                       public void onFailure(Call<UploadStudentMarksResponse> call, Throwable t) {
                           Log.d("False", t.getLocalizedMessage());
                           Toast.makeText(getContext(),"Couldn't Update the marks",Toast.LENGTH_LONG).show();
                           t.printStackTrace();
                       }
                   });
               } catch (Exception e) {
                   e.printStackTrace();
                   Log.d("ERORROORO",e.getLocalizedMessage());
               }


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
