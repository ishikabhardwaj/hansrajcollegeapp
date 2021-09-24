package com.example.hansrajcollege;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MarksFragment extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
    CustomSpinner s5,s6;
    Button b2;
    RadioGroup type;
    RadioButton assignment,internal;
    int selected_type;
    String subject[]={"Select Subject", "MP", "TOC", "IT", "DAV"};
    String Number[]={"Select Number"};
    String Anumber[]={"Select Number", "Assignment 1","Assignment 2","Assignment 3", "Assignment 4", "Assignment 5"};
    String Inumber[]={"Select Number", "Internal Assessment 1","Internal Assessment 2", "Internal Assessment 3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_marks, container, false);
        s5 = (CustomSpinner) root.findViewById(R.id.subject);
        s6 = (CustomSpinner) root.findViewById(R.id.number);
        s5.setSpinnerEventsListener(this);
        s6.setSpinnerEventsListener(this);
        //s2.setEnabled(false);
        //s2.setClickable(false);
        ArrayAdapter sub = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, subject);
        ArrayAdapter an1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Anumber);
        ArrayAdapter ian1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Inumber);
        ArrayAdapter n1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Number);
        sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s5.setAdapter(sub);

        b2 = (Button) root.findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.getCheckedRadioButtonId() == -1) {
                    n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s6.setAdapter(n1);
                    //no button is selected
                    Toast.makeText(getActivity(), "select a radio button", Toast.LENGTH_SHORT).show();
                }
                else {
                    //getting the id of the selected radio button
                    //assigning the value to selected_type according to selected radio button
                    int selected_id = type.getCheckedRadioButtonId();
                    RadioButton selected_R_button = (RadioButton) root.findViewById(selected_id);
                    if (selected_R_button.getText() == "Assignment") {
                        selected_type = 0;
                        an1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        s6.setAdapter(an1);
                    }
                    else if (selected_R_button.getText() == "Internal") {
                        selected_type = 1;
                        ian1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        s6.setAdapter(ian1);
                    }
                }

// MP ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Assignment1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Assignment2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Assignment3");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 4", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Assignment4");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Assignment5");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "MP Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Internal1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "MP Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Internal2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "MP Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "MP");
                    intent1.putExtra("Type_Selected", "Internal3");
                    startActivity(intent1);
                }

                // TOC ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Assignment1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Assignment2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Assignment3");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 4", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Assignment4");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Assignment5");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "TOC Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Internal1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "TOC Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Internal2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "TOC Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "TOC");
                    intent1.putExtra("Type_Selected", "Internal3");
                    startActivity(intent1);
                }

                // IT ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Assignment1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Assignment2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Assignment3");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 4", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Assignment4");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Assignment5");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "IT Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Internal1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "IT Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Internal2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "IT Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "IT");
                    intent1.putExtra("Type_Selected", "Internal3");
                    startActivity(intent1);
                }

                // DAV ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Assignment1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Assignment2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Assignment3");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 4", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Assignment4");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Assignment5");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "DAV Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Internal1");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "DAV Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Internal2");
                    startActivity(intent1);
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "DAV Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(getContext(), MarksDisplay.class);
                    intent1.putExtra("Subject_Selected", "DAV");
                    intent1.putExtra("Type_Selected", "Internal3");
                    startActivity(intent1);
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