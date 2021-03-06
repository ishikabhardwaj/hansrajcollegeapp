package com.hans.hansrajcollege;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hans.hansrajcollege.models.FacultyLoginResponse;
import com.hans.hansrajcollege.models.LoginRequest;
import com.hans.hansrajcollege.models.StudentLoginResponse;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_fragment extends Fragment {
    private Session session;
    private UserService apiService;
    private AuthenticationListener  authenticationListener;

EditText userName, Password;
Button btnlogin;
RadioGroup designation;
RadioButton faculty,student;
int selected_designation;

    public Login_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_login_fragment, container, false);
        userName = (EditText) root.findViewById(R.id.username_edit);
        Password = (EditText) root.findViewById(R.id.password_edit);
        btnlogin = (Button) root.findViewById(R.id.login_btn);
        designation = (RadioGroup) root.findViewById(R.id.radio_who);
        faculty = (RadioButton) root.findViewById(R.id.Faculty);
        student = (RadioButton) root.findViewById(R.id.Student);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (designation.getCheckedRadioButtonId() == -1) {
                    //no button is selected
                    Toast.makeText(getActivity(), "select a radio button", Toast.LENGTH_SHORT).show();
                }
                else {
                    //getting the id of the selected radio button
                    //assigning the value to selected_designation according to selected radio button
                    int selected_id = designation.getCheckedRadioButtonId();
                    RadioButton selected_R_button = (RadioButton) root.findViewById(selected_id);
                    //Toast.makeText(getActivity(),selected_R_button.getText(),Toast.LENGTH_LONG).show();
                   if (selected_R_button.getText().equals("Student")) {
                        selected_designation = 2;
                    }
                    else if (selected_R_button.getText().equals("Faculty")) {
                        selected_designation = 1;
                    }
                    else {
                        Toast.makeText(getActivity(),selected_R_button.getText(),Toast.LENGTH_LONG).show();
                    }
                    if (TextUtils.isEmpty(userName.getText().toString()) || TextUtils.isEmpty(Password.getText().toString())) {
                        //password and Username is not entered by the user
                        Toast.makeText(getActivity(), "Username / Password Required", Toast.LENGTH_LONG).show();
                    }
                    else {
                        //proceed to login
                        login();
                    }
                }
            }
        });
        return root;
    }
            //12230
            private void login() {
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setUid(userName.getText().toString());
                loginRequest.setPassword(Password.getText().toString());
                loginRequest.setRole(selected_designation);

                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                int cacheSize = 10 * 1024 * 1024; // 10 MB
                Cache cache = new Cache(getActivity().getCacheDir(), cacheSize);

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(httpLoggingInterceptor)
                        .cache(cache)
                        .build();

                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://34.82.126.49/")
                        .client(okHttpClient)
                        .build();


                UserService userService = retrofit.create(UserService.class);


                if (selected_designation == 2) {
                    Call<StudentLoginResponse> loginResponseCall = userService.userLogin(loginRequest);
                    loginResponseCall.enqueue(new Callback<StudentLoginResponse>() {
                        @Override
                        public void onResponse(Call<StudentLoginResponse> call, Response<StudentLoginResponse> response) {
                            if (response.isSuccessful()) {
                                //Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_LONG).show();

                                Log.d("Data success", response.toString());
                                //if (selected_designation == 0) {
                                    //intent to student vala dashboard
                                //} else if (selected_designation == 1) {
                                    //intent to teacher vala dashboard
                                 //   startActivity(new Intent(getContext(), TeacherDashboard2.class));
                                //}

                                SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
                                SharedPreferences.Editor editor=pref.edit();
                                editor.putInt("semester",response.body().getSemester());
                                editor.putString("university_roll_no",response.body().getUniversity_roll_no());
                                editor.putString("name",response.body().getName());
                                editor.putString("email",response.body().getEmail());
                                editor.putString("course",response.body().getCourse());
                                editor.putString("refresh",response.body().getToken().getRefresh());
                                editor.putString("access",response.body().getToken().getAccess());
                                editor.putString("uid",response.body().getUid());
                                editor.commit();



                                startActivity(new Intent(getContext(), StudentDashboard.class));


                            } else {
                                Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_LONG).show();
                                Log.d("Data fail", response.toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<StudentLoginResponse> call, Throwable t) {
                            Toast.makeText(getActivity(), "Throwable fail" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                            Log.d("Data fail", t.getLocalizedMessage());
                        }
                    });
                }

                else{
                    Call<FacultyLoginResponse> loginResponseCall = userService.userLogin_F(loginRequest);
                    loginResponseCall.enqueue(new Callback<FacultyLoginResponse>() {
                        @Override
                        public void onResponse(Call<FacultyLoginResponse> call, Response<FacultyLoginResponse> response) {
                            if (response.isSuccessful()) {
                                //Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_LONG).show();

                                Log.d("Data success", response.toString());
                                //if (selected_designation == 0) {
                                    //intent to student vala dashboard
                                  //  startActivity(new Intent(getContext(), StudentDashboard.class));
                                //} else if (selected_designation == 1) {
                                    //intent to teacher vala dashboard

                                SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
                                SharedPreferences.Editor editor=pref.edit();
                                editor.putString("name",response.body().getName());
                                editor.putString("email",response.body().getEmail());
                                editor.putString("uid",response.body().getUid());
                                editor.putString("department",response.body().getDepartment());
                                editor.putString("refresh",response.body().getToken().getRefresh());
                                editor.putString("access",response.body().getToken().getAccess());
                                editor.commit();



                                    startActivity(new Intent(getContext(), TeacherDashboard2.class));
                                //}
                            } else {
                                Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_LONG).show();
                                Log.d("Data fail", response.toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<FacultyLoginResponse> call, Throwable t) {
                            Toast.makeText(getActivity(), "Throwable fail" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                            Log.d("Data fail", t.getLocalizedMessage());
                        }
                    });
                }


    }




    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    public Session getSession() {
        if (session == null) {
            session = new Session() {
                @Override
                public boolean isLoggedIn() {
                    // check if token exist or not
                    // return true if exist otherwise false
                    // assuming that token exists
                    return true;
                }

                @Override
                public void saveToken(String token) {

                }

                @Override
                public String getToken() {
                    return null;
                }

                @Override
                public void saveEmail(String email) {

                }

                @Override
                public String getEmail() {
                    return null;
                }

                @Override
                public void savePassword(String password) {

                }

                @Override
                public String getPassword() {
                    return null;
                }


                @Override
                public void invalidate() {
                    // get called when user become logged out
                    // delete token and other user info
                    // (i.e: email, password)
                    // from the storage

                    // sending logged out event to it's listener
                    // i.e: Activity, Fragment, Service
                    if (authenticationListener != null) {
                        authenticationListener.onUserLoggedOut();
                    }
                }
            };
        }

        return session;
    }

    public interface AuthenticationListener {
        void onUserLoggedOut();
    }

    public void setAuthenticationListener(AuthenticationListener listener) {
        this.authenticationListener = listener;
    }

    public UserService getApiService() {
        if (apiService == null) {
            apiService = provideRetrofit(UserService.URL).create(UserService.class);
        }
        return apiService;
    }

    private Retrofit provideRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        return okhttpClientBuilder.build();
    }



}