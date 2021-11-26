package com.hans.hansrajcollege;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class Syllabus_fragment extends Fragment implements CustomSpinner.OnSpinnerEventsListener {
    CustomSpinner s1,s2;
    Button b;
    String faculty[]={"Select Department", "Department of Science","Department of Arts and Commerce"};
    String course[]={"Select Course"};
    String ScienceCourse[]={"Select Course", "B.Sc. (H) Botany","B.Sc. (H) Chemistry","B.Sc. (H) Computer Science","B.Sc. (H) Electronics","B.Sc. (H) Mathematics","B.Sc. (H) Physics","B.Sc. (H) Zoology"};
    String ArtComCourse[]={"Select Course", "B.Com. (H)","B.A. (H) Economics","B.A. (H) English","B.A. (H) Hindi","B.A. (H) History","B.A. (H) Philosophy","B.A. (H) Physical Education","B.A. (H) Sanskrit"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_syllabus_fragment, container, false);
        s1 = (CustomSpinner) root.findViewById(R.id.spinner);
        s2 = (CustomSpinner) root.findViewById(R.id.spinner2);
        s1.setSpinnerEventsListener(this);
        s2.setSpinnerEventsListener(this);
        //s2.setEnabled(false);
        //s2.setClickable(false);
        ArrayAdapter aa = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, faculty);
        ArrayAdapter ab = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, ScienceCourse);
        ArrayAdapter ac = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, ArtComCourse);
        ArrayAdapter ad = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, course);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(aa);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s2.setEnabled(true);
                if (position == 1) {
                    ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s2.setAdapter(ab);
                } else if (position == 2) {
                    ac.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s2.setAdapter(ac);
                } else {
                    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s2.setAdapter(ad);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b = (Button) root.findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s1.getSelectedItem().toString() == "Department of Science" && s2.getSelectedItem().toString() == "B.Sc. (H) Botany") {
                    Toast.makeText(getActivity(), "Botany", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.Sc(H)%20Botany.pdf")));//Copy link of B.Sc(Hons.) Botany Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Science" && s2.getSelectedItem().toString() == "B.Sc. (H) Chemistry") {
                    Toast.makeText(getActivity(), "Chemistry", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.%20Sc%20Hons%20Chemistry.pdf")));//Copy link of B.Sc(Hons.) Chemistry Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Science" && s2.getSelectedItem().toString() == "B.Sc. (H) Computer Science") {
                    Toast.makeText(getActivity(), "Computer Science", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.Sc(H)%20Computer%20Science.pdf")));//Copy link of B.Sc(Hons.) Computer Science Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Science" && s2.getSelectedItem().toString() == "B.Sc. (H) Electronics") {
                    Toast.makeText(getActivity(), "Electronics", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.Sc(H%20)Electronics.pdf")));//Copy link of B.Sc(Hons.) Electronics Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Science" && s2.getSelectedItem().toString() == "B.Sc. (H) Mathematics") {
                    Toast.makeText(getActivity(), "Mathematics", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.Sc(H)%20Mathematics.pdf")));//Copy link of B.Sc(Hons.) Mathematics Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Science" && s2.getSelectedItem().toString() == "B.Sc. (H) Physics") {
                    Toast.makeText(getActivity(), "Physics", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.Sc(H)%20Physics.pdf")));//Copy link of B.Sc(Hons.) Physics Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Science" && s2.getSelectedItem().toString() == "B.Sc. (H) Zoology") {
                    Toast.makeText(getActivity(), "Zoology", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.%20Sc.%20(Hons.)%20Zoology.pdf")));//Copy link of B.Sc(Hons.) Zoology Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.Com. (H)") {
                    Toast.makeText(getActivity(), "B.Com(Hons.)", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.Com(h).pdf")));//Copy link of B.Com(Hons.) Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.A. (H) Economics") {
                    Toast.makeText(getActivity(), "B.A(Hons.) Economics", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.A.%20(Hons.)%20Economics.pdf")));//Copy link of B.A(Hons.) Economics Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.A. (H) English") {
                    Toast.makeText(getActivity(), "B.A(Hons.) English", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.A(H)%20English.pdf")));//Copy link of B.A(Hons.) English Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.A. (H) Hindi") {
                    Toast.makeText(getActivity(), "B.A(Hons.) Hindi", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.A.%20(Hons.)%20Hindi.pdf")));//Copy link of B.A(Hons.) Hindi Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.A. (H) History") {
                    Toast.makeText(getActivity(), "B.A(Hons.) History", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.A(H)%20History.pdf")));//Copy link of B.A(Hons.) History Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.A. (H) Philosophy") {
                    Toast.makeText(getActivity(), "B.A(Hons.) Philosophy", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/BA-Hons-Philosophy-Booklet2.pdf")));//Copy link of B.A(Hons.) Philosophy Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.A. (H) Physical Education") {
                    Toast.makeText(getActivity(), "B.A(Hons.) Physical Education", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("")));//Copy link of B.A(Hons.) Physical Education Syllabus
                } else if (s1.getSelectedItem().toString() == "Department of Arts and Commerce" && s2.getSelectedItem().toString() == "B.A. (H) Sanskrit") {
                    Toast.makeText(getActivity(), "B.A(Hons.) Sanskrit", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://hansrajcollege.ac.in/files/syllabus/B.A%20(H)Sanskrit.pdf")));//Copy link of B.A(Hons.) Sanskrit Syllabus
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