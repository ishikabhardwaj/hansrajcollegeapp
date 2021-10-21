package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.subject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddAttendanceFragment extends Fragment implements CustomSpinner.OnSpinnerEventsListener{

    CustomSpinner s1,s2;
    Button b;
    String Subject[]={"Select Subject", "Programming in Java","Android Development","Software Engineering","Microprocessor"};
    String Months[]={"Month","January","February","March","April","May","June","July","August","Septemer","October","November","December"};
    ArrayList<String> sub=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        populate_spinner();
        Log.d("SPINNER 1",sub.toString());

        View root = inflater.inflate(R.layout.fragment_add_attendance, container, false);

        s1 = (CustomSpinner) root.findViewById(R.id.spinnercourse);
        s1.setSpinnerEventsListener(this);


        s2 = (CustomSpinner) root.findViewById(R.id.spinner5);
        s2.setSpinnerEventsListener(this);
        ArrayAdapter ab = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Months);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(ab);
        b = (Button) root.findViewById(R.id.buttonforsubject);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Bundle bundle = new Bundle();
                bundle.putString("Subject_Selected", s1.getSelectedItem().toString());
                bundle.putString("Month_Selected", s2.getSelectedItem().toString());
                TeacherAttendance fragment = new TeacherAttendance();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return root;
    }

    private void populate_spinner(){
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);

        Call<List<subject>> populate= ApiClient.getUserService(pref.getString("access",null)).subject_list();
        populate.enqueue(new Callback<List<subject>>() {
            @Override
            public void onResponse(Call<List<subject>> call, Response<List<subject>> response) {
                for(int i=0;i<response.body().size();i++){
                    sub.add(response.body().get(i).getSubject_name());
                }
                ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, sub);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s1.setAdapter(aa);

                Log.d("SAB",sub.toString());


            }

            @Override
            public void onFailure(Call<List<subject>> call, Throwable t) {
                Log.d("ERROR",t.getLocalizedMessage());

            }
        });
    }






    @Override
    public void onPopupWindowOpened(Spinner spinner) {

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

    }
}