package com.example.hansrajcollege;

import com.example.hansrajcollege.models.FacultyLoginResponse;
import com.example.hansrajcollege.models.Get_Marks_Request;
import com.example.hansrajcollege.models.Get_Marks_Response;
import com.example.hansrajcollege.models.Get_Subject_List_Response;
import com.example.hansrajcollege.models.Get_timetable_request;
import com.example.hansrajcollege.models.Get_timetable_response;
import com.example.hansrajcollege.models.LoginRequest;
import com.example.hansrajcollege.models.StudentAttendanceRequest;
import com.example.hansrajcollege.models.StudentAttendanceResponse;
import com.example.hansrajcollege.models.StudentLoginResponse;
import com.example.hansrajcollege.models.StudentMarksRequest;
import com.example.hansrajcollege.models.StudentMarksResponse;
import com.example.hansrajcollege.models.Subject_Teacher_Details_Response;
import com.example.hansrajcollege.models.UploadStudentAttendanceRequest;
import com.example.hansrajcollege.models.UploadStudentAttendanceResponse;
import com.example.hansrajcollege.models.UploadStudentMarksRequest;
import com.example.hansrajcollege.models.View_Attendance_Response;
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

    //to fetch subject teacher details corresponding to each student
    @GET("/students/subject-teachers-details/")
    Call<List<Subject_Teacher_Details_Response>> SUBJECT_TEACHER_DETAILS_RESPONSE_CALL();

    //to get the subject list for each student
    //to populate view attendance and view marks spinner
    @GET("/students/get-subject-list/")
    Call<List<Get_Subject_List_Response>> GET_SUBJECT_LIST_RESPONSE_CALL();

    //to fetch the total attendance up till last month for each student
    @GET("/attendance/view-attendance/")
    Call<List<View_Attendance_Response>> VIEW_ATTENDANCE_RESPONSE_CALL();

    //to fetch the marks of assignment/internal in student module
    @POST("/marks/get-marks/")
    Call<List<Get_Marks_Response>> GET_MARKS_RESPONSE_CALL(@Body Get_Marks_Request get_marks_request);

    //get the timetable for each day of the week
    @POST("/timetable/get-timetable/")
    Call<List<Get_timetable_response>> GET_TIMETABLE_RESPONSE_CALL(@Body Get_timetable_request get_timetable_request);

    @POST("accounts/logout/")
    Call<logout_respond> logout(@Body logout_request logout_request);

    @POST("marks/upload-marks/")
    Call<UploadStudentMarksResponse> upload_marks(@Body UploadStudentMarksRequest uploadStudentMarksRequest);


}
