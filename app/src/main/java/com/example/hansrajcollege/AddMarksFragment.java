package com.example.hansrajcollege;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.subject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddMarksFragment extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
    CustomSpinner s5,s6;
    Button b4;
    RadioGroup type;
    RadioButton assignment,internal;
    ArrayList<String> subj= new ArrayList<>();
    int selected_type;
    String subject[]={"Select Subject", "MicroProcessor", "Theory of Computation", "Internet Technology", "Data Analysis and Visualization"};
    String Number[]={"Select Number"};
    String Anumber[]={"Select Number", "Assignment 1","Assignment 2","Assignment 3", "Assignment 4", "Assignment 5"};
    String Inumber[]={"Select Number", "Internal Assessment 1","Internal Assessment 2", "Internal Assessment 3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        populate_spinner();
        View root = inflater.inflate(R.layout.fragment_add_marks, container, false);
        s5 = (CustomSpinner) root.findViewById(R.id.subject);
        s6 = (CustomSpinner) root.findViewById(R.id.number);
        s5.setSpinnerEventsListener(this);
        s6.setSpinnerEventsListener(this);
        //getting the id of the selected radio button
        //assigning the value to selected_type according to selected radio button

        assignment= (RadioButton) root.findViewById(R.id.Assignment);
        internal= (RadioButton) root.findViewById(R.id.Internal);
        //s2.setEnabled(false);
        //s2.setClickable(false);
        ArrayAdapter sub = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, subject);
        ArrayAdapter an1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Anumber);
        ArrayAdapter ian1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Inumber);
        ArrayAdapter n1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Number);
        sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s5.setAdapter(sub);
        n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s6.setAdapter(n1);
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
                        //Do some logic if the male radio button is checked
                        {an1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s6.setAdapter(an1);}
                        break;
                    case R.id.Internal:
                        if (checked)
                        //Do some logic if the female radio button is checked
                        {ian1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s6.setAdapter(ian1);}
                        break;
                    default:
                        n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        s6.setAdapter(n1);

                }
            }
        });

        b4 = (Button) root.findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.getCheckedRadioButtonId() == -1) {
                    n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s6.setAdapter(n1);
                    //no button is selected
                    Toast.makeText(getActivity(), "select a radio button", Toast.LENGTH_SHORT).show();
                }

                if(!(s5.getSelectedItem().toString()=="Select Subject" || s6.getSelectedItem().toString()=="Select Number")) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", s5.getSelectedItem().toString());
                    bundle.putString("Type_Selected", s6.getSelectedItem().toString());
                    TeacherMarksDisplay fragment = new TeacherMarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
                if(s5.getSelectedItem().toString()=="Select Subject" && s6.getSelectedItem().toString()=="Select Number"){
                    Toast.makeText(getActivity(),"Select Subject and Number",Toast.LENGTH_LONG).show();
                }
                else {
                    if (s5.getSelectedItem().toString() == "Select Subject") {
                        Toast.makeText(getActivity(), "Select Subject", Toast.LENGTH_LONG).show();
                    }
                    if (s6.getSelectedItem().toString() == "Select Number") {
                        Toast.makeText(getActivity(), "Select Number", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        return root;
    }

    private void populate_spinner(){
        SharedPreferences pref=getContext().getSharedPreferences("MyPref",0);

        Call<List<com.example.hansrajcollege.models.subject>> populate= ApiClient.getUserService(pref.getString("access",null)).subject_list();
        populate.enqueue(new Callback<List<subject>>() {
            @Override
            public void onResponse(Call<List<subject>> call, Response<List<subject>> response) {
                for(int i=0;i<response.body().size();i++){
                    subj.add(response.body().get(i).getSubject_name());
                }
                ArrayAdapter sub = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, subj);
                sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s5.setAdapter(sub);

                Log.d("SAB",subj.toString());

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