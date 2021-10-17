package com.example.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class ViewAttendance extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
    CustomSpinner s5,s6;
    Button b4;
    int selected_type;
    String subject[]={"Select Subject", "MicroProcessor", "Theory of Computation", "Internet Technology", "Data Analysis and Visualization"};
    String Months[]={"Month","January","February","March","April","May","June","July","August","Septemer","October","November","December"};
    String Month[]={"Month"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        ArrayAdapter n2 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item,Month);
        sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        n2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s5.setAdapter(sub);
        s6.setAdapter(n2);
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

                  Bundle bundle = new Bundle();
                  bundle.putString("Subject_Selected", s5.getSelectedItem().toString());
                  bundle.putString("Month_Selected", s6.getSelectedItem().toString());
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
    @Override
    public void onPopupWindowOpened(Spinner spinner) {


    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

    }

}