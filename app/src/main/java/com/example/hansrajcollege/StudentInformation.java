package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.student_details;
import com.example.hansrajcollege.models.subject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StudentInformation extends Fragment {
    ArrayList<String> sub=new ArrayList<>();
    ArrayList<Integer> sub_id=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        View root=inflater.inflate(R.layout.fragment_student_information, container, false);
        ListView list= (ListView) root.findViewById(R.id.list);

        Call<List<subject>> populate= ApiClient.getUserService(pref.getString("access",null)).subject_list();

        populate.enqueue(new Callback<List<subject>>() {
            @Override
            public void onResponse(Call<List<subject>> call, Response<List<subject>> response) {
                for(int i=0;i<response.body().size();i++){
                    sub.add(response.body().get(i).getSubject_name());
                    sub_id.add(response.body().get(i).getSubject_id());
                }
                Log.d("SAB1",sub.toString());
                ArrayAdapter<String> customAdapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_listview_subject, R.id.textView2,sub);
                list.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<List<subject>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());
            }
        });

        Log.d("SAB2",sub.toString());

        String Subjects[]={"Programming in Java","Android Development","Software Engineering","Microprocessor"};


            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int search_subid = search((String)list.getItemAtPosition(position));
                    Log.d("selected", (String) list.getItemAtPosition(position));
                    Log.d("selected", String.valueOf(search_subid));

                    SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
                    SharedPreferences.Editor editor=pref.edit();
                    editor.putInt("selected_sub",search_subid);
                    editor.commit();


                    Fragment fragment = new ListOfStudentsFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            });
            return root;
        }



        int search(String itemAtPosition){
            int i=0;

            for(i=0;i<sub.size();i++){
                if(sub.get(i)== itemAtPosition){
                    break;
                }
            }
            return sub_id.get(i);
        }
    }
