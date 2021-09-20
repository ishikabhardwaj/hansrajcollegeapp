package com.example.hansrajcollege;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.POST;
public interface UserService {
    //dummy Url
    String URL = "http://34.82.126.49/";
    @POST("login/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}
