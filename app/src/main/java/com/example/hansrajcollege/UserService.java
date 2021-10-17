package com.example.hansrajcollege;

import com.example.hansrajcollege.models.FacultyLoginResponse;
import com.example.hansrajcollege.models.LoginRequest;
import com.example.hansrajcollege.models.StudentLoginResponse;
import com.example.hansrajcollege.models.SubjectList;
import com.example.hansrajcollege.models.student_details;
import com.example.hansrajcollege.models.studentlist_request;
import com.example.hansrajcollege.models.subject;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface UserService {
    //dummy Url
    String URL = "http://34.82.126.49/";
    @POST("/accounts/login/")
    Call<StudentLoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("/accounts/login/")
    Call<FacultyLoginResponse> userLogin_F(@Body LoginRequest loginRequest);

    @GET("faculty/subjects-list/")
    Call<List<subject>> subject_list();

    @POST("faculty/students-details/")
    Call<List<student_details>> student_list(@Body studentlist_request studentlist_request);

}
