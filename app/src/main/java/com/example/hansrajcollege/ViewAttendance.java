package com.example.hansrajcollege;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.subject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ViewAttendance extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
    CustomSpinner s5,s6;
    Button b4;
    int selected_type;
    String subject[]={"Select Subject", "MicroProcessor", "Theory of Computation", "Internet Technology", "Data Analysis and Visualization"};
    String Months[]={"Month","m1","m2","m3","m4","m5","m6","m7","m8","m9","m10","m11","m12"};
    //String Months[]={"Month","January","February","March","April","May","June","July","August","Septemer","October","November","December"};
    //String Month[]={"Month"};
    ArrayList<String> sub=new ArrayList<>();
    ArrayList<Integer> sub_id=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //populating spinner with the response we get from server corresponding to T-id
        populate_spinner();
        Log.d("SPINNER 1",sub.toString());
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_view_attendance, container, false);
        s5 = (CustomSpinner) root.findViewById(R.id.subject);
        s6 = (CustomSpinner) root.findViewById(R.id.month);
        s5.setSpinnerEventsListener(this);
        s6.setSpinnerEventsListener(this);
        //getting the id of the selected radio button
        //assigning the value to selected_type according to selected radio button
        //s2.setEnabled(false);
        //s2.setClickable(false);
        ArrayAdapter sub = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, subject);
        ArrayAdapter n1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Months);
        //ArrayAdapter n2 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item,Month);
        sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s5.setAdapter(sub);
        s6.setAdapter(n1);
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s6.setEnabled(true);
                if (position != 0) {
                    n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s6.setAdapter(n1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        b4 = (Button) root.findViewById(R.id.buttonviewAtt);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              if(!(s5.getSelectedItem().toString()=="Select Subject" || s6.getSelectedItem().toString()=="Month")) {
                  //Toast.makeText(getActivity(),"Fine till here",Toast.LENGTH_LONG).show();


                  int search_subid = search(s5.getSelectedItem().toString());
                  //SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
                  //SharedPreferences.Editor editor=pref.edit();
                  //editor.putInt("selected_sub",search_subid);
                  //editor.commit();

                  Bundle bundle = new Bundle();
                  bundle.putString("Subject_Selected", s5.getSelectedItem().toString());
                  bundle.putString("Month_Selected", s6.getSelectedItem().toString());
                  bundle.putInt("selected_sub_id",search_subid);

                  TeacherAttendanceDisplay fragment = new TeacherAttendanceDisplay();
                  fragment.setArguments(bundle);
                  getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
              }
              if(s5.getSelectedItem().toString()=="Select Subject" && s6.getSelectedItem().toString()=="Month"){
                  Toast.makeText(getActivity(),"Select Subject and Month",Toast.LENGTH_LONG).show();
              }
              else {
                  if (s5.getSelectedItem().toString() == "Select Subject") {
                      Toast.makeText(getActivity(), "Select Subject", Toast.LENGTH_LONG).show();
                  }
                  if (s6.getSelectedItem().toString() == "Month") {
                      Toast.makeText(getActivity(), "Select Month", Toast.LENGTH_LONG).show();
                  }
              }
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


    private void populate_spinner(){
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);

        Call<List<com.example.hansrajcollege.models.subject>> populate= ApiClient.getUserService(pref.getString("access",null)).subject_list();
        populate.enqueue(new Callback<List<subject>>() {
            @Override
            public void onResponse(Call<List<subject>> call, Response<List<subject>> response) {
                sub.add(0,"Select Subject");
                sub_id.add(0,0);
                for(int i=0;i<response.body().size();i++){
                    sub.add(response.body().get(i).getSubject_name());
                    sub_id.add(response.body().get(i).getSubject_id());
                }
                ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, sub);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s5.setAdapter(aa);

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