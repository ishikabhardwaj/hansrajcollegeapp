package com.example.hansrajcollege;

import com.example.hansrajcollege.models.FacultyLoginResponse;
import com.example.hansrajcollege.models.LoginRequest;
import com.example.hansrajcollege.models.StudentAttendanceRequest;
import com.example.hansrajcollege.models.StudentAttendanceResponse;
import com.example.hansrajcollege.models.StudentLoginResponse;
import com.example.hansrajcollege.models.StudentMarksRequest;
import com.example.hansrajcollege.models.StudentMarksResponse;
import com.example.hansrajcollege.models.SubjectList;
import com.example.hansrajcollege.models.UploadStudentAttendanceRequest;
import com.example.hansrajcollege.models.UploadStudentMarksRequest;
import com.example.hansrajcollege.models.logout_request;
import com.example.hansrajcollege.models.logout_respond;
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

    //to fetch the marks of the student enrolled in a subject for teacher's dashboard
    @POST("marks/students-marks/")
    Call<List<StudentMarksResponse>> student_marks(@Body StudentMarksRequest studentMarksRequest);

    //to fetch the attendance of the student enrolled in a subject for teacher's dashboard
    @POST("attendance/students-attendance/")
    Call<List<StudentAttendanceResponse>> student_attendance(@Body StudentAttendanceRequest studentAttendanceRequest);

    @POST("/attendance/upload-attendance/")
    Call<UploadStudentAttendanceResponse> upload_attendance(@Body UploadStudentAttendanceRequest uploadStudentAttendanceRequest);

    @POST("marks/upload-marks/")
    Call<UploadStudentMarksResponse> upload_marks(@Body UploadStudentMarksRequest uploadStudentMarksResponse);

    @POST("accounts/logout/")
    Call<logout_respond> logout(@Body logout_request logout_request);
}
