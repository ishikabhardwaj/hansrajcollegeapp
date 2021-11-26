package com.hans.hansrajcollege;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TImeTable_fragment extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
    CustomSpinner s3,s4;
    Button b1;
    String type[]={"Select Type", "Class Time Table","Faculty Time Table"};
    String stream[]={"Select Stream"};
    String ClassStream[]={"Select Stream", "Science","Generic Elective (GE) Science","Arts & Commerce"};
    String FacultyStream[]={"Select Stream", "Science","Arts & Commerce"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_t_ime_table_fragment, container, false);
        s3 = (CustomSpinner) root.findViewById(R.id.spinner3);
        s4 = (CustomSpinner) root.findViewById(R.id.spinner4);
        s3.setSpinnerEventsListener(this);
        s4.setSpinnerEventsListener(this);
        //s2.setEnabled(false);
        //s2.setClickable(false);
        ArrayAdapter t1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, type);
        ArrayAdapter cs1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, ClassStream);
        ArrayAdapter fs1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, FacultyStream);
        ArrayAdapter s1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, stream);
        t1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(t1);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s4.setEnabled(true);
                if (position == 1) {
                    cs1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s4.setAdapter(cs1);
                } else if (position == 2) {
                    fs1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s4.setAdapter(fs1);
                } else {
                    s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s4.setAdapter(s1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b1 = (Button) root.findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s3.getSelectedItem().toString() == "Class Time Table" && s4.getSelectedItem().toString() == "Science") {
                    Toast.makeText(getActivity(), "Science Time Table", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.hansrajcollege.ac.in//hCPanel/uploads/timetable/Science_Class_Time_Table_without_First_year_ODD_Semester_290721-2021---22.pdf")));//Copy link of Science Time Table
                } else if (s3.getSelectedItem().toString() == "Class Time Table" && s4.getSelectedItem().toString() == "Generic Elective (GE) Science") {
                    Toast.makeText(getActivity(), "Generic Elective (GE) Science Time Table", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.hansrajcollege.ac.in//hCPanel/uploads/timetable/Science_GE_Time_Table_without_first_year_ODD_Semester_19th_July_2021-2021---22.pdf")));//Copy link of Generic Elective (GE) Science Time Table
                } else if (s3.getSelectedItem().toString() == "Class Time Table" && s4.getSelectedItem().toString() == "Arts & Commerce") {
                    Toast.makeText(getActivity(), "Arts & Commerce Time Table", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.hansrajcollege.ac.in//hCPanel/uploads/timetable/Arts_and_Commerce_Class_TT_-Revised-2021---22.pdf")));//Copy link of Arts & Commerce Time Table
                } else if (s3.getSelectedItem().toString() == "Faculty Time Table" && s4.getSelectedItem().toString() == "Science") {
                    Toast.makeText(getActivity(), "Science Time Table", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.hansrajcollege.ac.in//hCPanel/uploads/timetable/Science_Teacher_Time_Table_ODD_Semester_290721-2021---22.pdf")));//Copy link of Science Time Table
                } else if (s3.getSelectedItem().toString() == "Faculty Time Table" && s4.getSelectedItem().toString() == "Arts & Commerce") {
                    Toast.makeText(getActivity(), "Arts & Commerce Time Table", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.hansrajcollege.ac.in//hCPanel/uploads/timetable/Arts_and_Commerce_Teachers_TT-_Revised-2021---22.pdf")));//Copy link of Arts & Commerce Time Table
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