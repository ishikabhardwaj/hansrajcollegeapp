package com.example.hansrajcollege;

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

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.Get_timetable_request;
import com.example.hansrajcollege.models.Get_timetable_response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WednesdayFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_wednesday, container, false);
        final ArrayList<Time> words= new ArrayList<Time>();
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        ListView list= (ListView) root.findViewById(R.id.list);

        //making request
        Get_timetable_request get_timetable_request=new Get_timetable_request();
        get_timetable_request.setDay("Wednesday");

        Call<List<Get_timetable_response>> populate= ApiClient.getUserService(pref.getString("access",null)).GET_TIMETABLE_RESPONSE_CALL(get_timetable_request);

        populate.enqueue(new Callback<List<Get_timetable_response>>() {
            @Override
            public void onResponse(Call<List<Get_timetable_response>> call, Response<List<Get_timetable_response>> response) {
                if(response.isSuccessful()){
                    if(response.body().size()==0){
                        Toast.makeText(getActivity(), "Data is not available", Toast.LENGTH_LONG).show();
                    }
                    else{
                        for(int i=0;i<response.body().size();i++){
                            words.add(new Time(response.body().get(i).getSubject(),
                                    response.body().get(i).getTeachers(),
                                    response.body().get(i).getTime()));
                        }
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Time time= words.get(position);
                            }

                        });
                        CustomAdapter customAdapter = new CustomAdapter(getActivity(), words,3);
                        list.setAdapter(customAdapter);
                    }
                }
                else{
                    Toast.makeText(getActivity(), "Data is not available", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Get_timetable_response>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });
        return root;
    }
}