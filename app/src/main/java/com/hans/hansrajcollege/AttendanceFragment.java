package com.hans.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hans.hansrajcollege.models.ApiClient;
import com.hans.hansrajcollege.models.View_Attendance_Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AttendanceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        View root= inflater.inflate(R.layout.fragment_attendance, container, false);

        final ArrayList<StudentAttendance> words= new ArrayList<StudentAttendance>();

        ListView attendance_List=(ListView)root.findViewById(R.id.attendance_list);

        Call<List<View_Attendance_Response>> populate= ApiClient.getUserService(pref.getString("access",null)).VIEW_ATTENDANCE_RESPONSE_CALL();
        populate.enqueue(new Callback<List<View_Attendance_Response>>() {
            @Override
            public void onResponse(Call<List<View_Attendance_Response>> call, Response<List<View_Attendance_Response>> response) {
                if(response.isSuccessful()){
                    if(response.body().size()==0){
                        Toast.makeText(getContext(),"Data is Not available",Toast.LENGTH_LONG).show();
                    }
                    else{
                        for(int i=0;i<response.body().size();i++){
                            String overall_attendance=Integer.toString(response.body().get(i).getAttendance())+"/"+
                                    Integer.toString(response.body().get(i).getOut_of());
                            float percentage=((float)response.body().get(i).getAttendance()/response.body().get(i).getOut_of() )*100;
                            words.add(new StudentAttendance(response.body().get(i).getSubject(),
                                    overall_attendance,percentage));

                            attendance_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    StudentAttendance SA=words.get(position);
                                }
                            });

                            Student_Attendance_Adapter customAdapter=new Student_Attendance_Adapter(getActivity(),words,3);
                            attendance_List.setAdapter(customAdapter);
                        }
                    }

                }
                else{
                    Toast.makeText(getContext(),"Data is Not available",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<View_Attendance_Response>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });
        return root;
    }
}