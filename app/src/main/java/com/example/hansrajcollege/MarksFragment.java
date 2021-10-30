package com.example.hansrajcollege;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.Get_Subject_List_Response;
import com.example.hansrajcollege.models.subject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MarksFragment extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
    CustomSpinner s5,s6;
    Button b4;
    RadioGroup type;
    RadioButton assignment,internal;
    int selected_type;
    String subject[]={"Select Subject", "MP", "TOC", "IT", "DAV"};
    String Number[]={"Select Number"};

    ArrayList<Integer> detail_id=new ArrayList<>();
    ArrayList<String> sub=new ArrayList<>();
    //String Anumber[]={"Select Number", "Assignment 1","Assignment 2","Assignment 3", "Assignment 4", "Assignment 5"};
    //String Inumber[]={"Select Number", "Internal Assessment 1","Internal Assessment 2", "Internal Assessment 3"};
    String validtype;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        populate_spinner();
        Log.d("SPINNER 1",sub.toString());
        View root = inflater.inflate(R.layout.fragment_marks, container, false);
        s5 = (CustomSpinner) root.findViewById(R.id.subject);
        s5.setSpinnerEventsListener(this);

        ArrayAdapter sub = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, subject);

        sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assignment= (RadioButton) root.findViewById(R.id.Assignment);
        internal= (RadioButton) root.findViewById(R.id.Internal);


        type= (RadioGroup) root.findViewById(R.id.radio_type);
        type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                //Get the id of the checked radio button in the group
                int radioButtonID = group.getCheckedRadioButtonId();

                //Get the radio button view from the group using the above id
                View radioButton = group.findViewById(radioButtonID);

                //Get whether the button is checked or not
                boolean checked = ((RadioButton) radioButton).isChecked();

                switch(radioButton.getId()) {
                    case R.id.Assignment:
                        if (checked)
                        {
                            validtype="assignment";
                        }
                        break;
                    case R.id.Internal:
                        if (checked)
                        {
                            validtype="internal";
                        }
                        break;

                }
            }
        });

        b4 = (Button) root.findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.getCheckedRadioButtonId() == -1) {
                    //no button is selected
                    Toast.makeText(getActivity(), "select a radio button", Toast.LENGTH_SHORT).show();
                }
                if(!(s5.getSelectedItem().toString()=="Select Subject" || type.getCheckedRadioButtonId() == -1)) {


                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", s5.getSelectedItem().toString());
                    bundle.putString("Type_Selected", validtype);
                    bundle.putInt("Subject_Detail_id",search(s5.getSelectedItem().toString()));
                    //Toast.makeText(getContext(),s5.getSelectedItem().toString()+validtype+search(s5.getSelectedItem().toString()),Toast.LENGTH_LONG).show();
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
                if(s5.getSelectedItem().toString()=="Select Subject" && type.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getActivity(),"Select Subject and Type",Toast.LENGTH_LONG).show();
                }
                else {
                    if (s5.getSelectedItem().toString() == "Select Subject") {
                        Toast.makeText(getActivity(), "Select Subject", Toast.LENGTH_LONG).show();
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
        return detail_id.get(i);
    }

    private void populate_spinner(){
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);
        Call<List<Get_Subject_List_Response>> populate= ApiClient.getUserService(pref.getString("access",null)).GET_SUBJECT_LIST_RESPONSE_CALL();
        populate.enqueue(new Callback<List<Get_Subject_List_Response>>() {
            @Override
            public void onResponse(Call<List<Get_Subject_List_Response>> call, Response<List<Get_Subject_List_Response>> response) {
                if(response.isSuccessful()){
                    sub.add(0,"Select Subject");
                    detail_id.add(0,0);
                    for(int i=0;i<response.body().size();i++){
                        sub.add(response.body().get(i).getSubject());
                        detail_id.add(response.body().get(i).getDetail_id());
                    }
                    Log.d("SUBJECT SPINNER",sub.toString());
                    ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, sub);
                    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s5.setAdapter(aa);
                }
                else{
                    Log.d("nhi chala","Nhi chala");
                    Toast.makeText(getContext(),"Couldn't find data",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Get_Subject_List_Response>> call, Throwable t) {
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