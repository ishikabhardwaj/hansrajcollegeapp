package com.example.hansrajcollege;

import com.example.hansrajcollege.models.FacultyLoginResponse;
import com.example.hansrajcollege.models.LoginRequest;
import com.example.hansrajcollege.models.StudentLoginResponse;
import com.example.hansrajcollege.models.SubjectList;

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
    Call<SubjectList> subject_list();

}
