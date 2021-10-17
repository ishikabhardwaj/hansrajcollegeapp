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
    CustomSpinner s5, s6, s7;
    Button b4;
    ArrayList<String> subj=new ArrayList<>();
    String subject[] = {"Select Subject", "MP", "TOC", "IT", "DAV"};
    String Number[] = {"Select", "Assignment", "Internal"};
    String Empty[] = {"Select"};
    String ANumber[] = {"Select Number", "Assignment 1", "Assignment 2", "Assignment 3", "Assignment 4", "Assignment 5"};
    String INumber[] = {"Select Number", "Internal Assessment 1", "Internal Assessment 2", "Internal Assessment 3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        populate_spinner();
        View root = inflater.inflate(R.layout.fragment_add_marks, container, false);
        s5 = (CustomSpinner) root.findViewById(R.id.spinner5);
        s6 = (CustomSpinner) root.findViewById(R.id.spinner6);
        s7 = (CustomSpinner) root.findViewById(R.id.spinner7);
        s5.setSpinnerEventsListener(this);
        s6.setSpinnerEventsListener(this);
        s7.setSpinnerEventsListener(this);



        ArrayAdapter n1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Number);
        ArrayAdapter an1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, ANumber);
        ArrayAdapter ian1 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, INumber);
        ArrayAdapter emp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, Empty);



        s6.setAdapter(n1);
        s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s7.setEnabled(true);
                if (position == 1) {
                    n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s7.setAdapter(an1);
                } else if (position == 2) {
                    n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s7.setAdapter(ian1);
                } else {
                    n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s7.setAdapter(emp);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b4 = (Button) root.findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // MP ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Assignment1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 2", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Assignment2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Assignment3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 4", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Assignment4");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "MP Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Assignment5");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "MP Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Internal1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "MP Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Internal2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "MP" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "MP Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "MP");
                    bundle.putString("Type_Selected", "Internal3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }

                // TOC ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Assignment1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 2", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Assignment2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Assignment3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 4", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Assignment4");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "TOC Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Assignment5");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "TOC Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Internal1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "TOC Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Internal2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "TOC" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "TOC Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "TOC");
                    bundle.putString("Type_Selected", "Internal3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }

                // IT ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Assignment1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 2", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Assignment2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Assignment3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Assignment4");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "IT Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Assignment5");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "IT Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Internal1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "IT Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Internal2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "IT" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "IT Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "IT");
                    bundle.putString("Type_Selected", "Internal3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }

                // DAV ASSIGNMENTS AND INTERNALS
                if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 1") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Assignment1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 2") {
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Assignment2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 3") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Assignment3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 4") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 4", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Assignment4");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Assignment 5") {
                    Toast.makeText(getActivity(), "DAV Marks for Assignment 5", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Assignment5");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Internal Assessment 1") {
                    Toast.makeText(getActivity(), "DAV Marks for Internal Assessment 1", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Internal1");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Internal Assessment 2") {
                    Toast.makeText(getActivity(), "DAV Marks for Internal Assessment 2", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Internal2");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                } else if (s5.getSelectedItem().toString() == "DAV" && s6.getSelectedItem().toString() == "Internal Assessment 3") {
                    Toast.makeText(getActivity(), "DAV Marks for Internal Assessment 3", Toast.LENGTH_LONG).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject_Selected", "DAV");
                    bundle.putString("Type_Selected", "Internal3");
                    MarksDisplay fragment = new MarksDisplay();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
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