package com.hans.hansrajcollege.models;

import android.util.Log;

import com.hans.hansrajcollege.UserService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit(String token){

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient= new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request orignalRequest=chain.request();

                        Request newRequest=orignalRequest.newBuilder()
                                .header("Authorization","Bearer "+token)
                                .build();

                        return chain.proceed(newRequest);
                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit= new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://34.82.126.49/")
                .client(okHttpClient)
                .build();
        Log.d("TOKEN",token);
        return retrofit;
    }

    

    public static UserService getUserService(String token){
        UserService userService= getRetrofit(token).create(UserService.class);
        return userService;
    }
}
