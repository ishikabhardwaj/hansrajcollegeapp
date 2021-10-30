package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.Get_Marks_Request;
import com.example.hansrajcollege.models.Get_Marks_Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MarksDisplay extends Fragment {


    TextView h1, d1, m1;
    ImageView i1;
    String subject, type;
    int detail_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        View root=inflater.inflate(R.layout.marksdisplay, container, false);
        h1 = root.findViewById(R.id.header);

        Bundle bundle= this.getArguments();
        subject= bundle.getString("Subject_Selected");
        type= bundle.getString("Type_Selected");
        detail_id=bundle.getInt("Subject_Detail_id");
        h1.setText(type + " Marks of " + subject);
        RecyclerView list=(RecyclerView) root.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ArrayList<MarksClassforStudent> words= new ArrayList<MarksClassforStudent>();

        Get_Marks_Request get_marks_request=new Get_Marks_Request();
        get_marks_request.setDetail_id(detail_id);
        get_marks_request.setField(type);

        Call<List<Get_Marks_Response>> populate= ApiClient.getUserService(pref.getString("access",null)).GET_MARKS_RESPONSE_CALL(get_marks_request);
        populate.enqueue(new Callback<List<Get_Marks_Response>>() {
            @Override
            public void onResponse(Call<List<Get_Marks_Response>> call, Response<List<Get_Marks_Response>> response) {
                if(response.isSuccessful()){
                    if(response.body().size()==0){
                        Toast.makeText(getContext(),"Data is not available",Toast.LENGTH_LONG).show();
                    }
                    else{
                        for(int i=0;i<response.body().size();i++){
                            String marks=response.body().get(i).getMarks()+"/"+response.body().get(i).getOut_of();
                            words.add(new MarksClassforStudent(response.body().get(i).getType(), marks));
                        }
                        list.setAdapter(new RecyclerAdapterForMarks(words));
                    }

                }
                else{
                    Toast.makeText(getContext(),"Data is not available",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Get_Marks_Response>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });
        return root;
    }
}

