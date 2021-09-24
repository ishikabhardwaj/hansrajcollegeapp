package com.example.hansrajcollege;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MarksDisplay extends AppCompatActivity {

    TextView h1, d1, m1;
    ImageView i1;
    String subject, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marksdisplay);
        h1 = (TextView) findViewById(R.id.subhead);
        i1 = (ImageView) findViewById(R.id.image);
        d1 = (TextView) findViewById(R.id.description);
        m1 = (TextView) findViewById(R.id.marksget);

        Intent intent = getIntent();
        subject = intent.getStringExtra("Subject_Selected");
        type = intent.getStringExtra("Type_Selected");
        if (subject.equals("MP")) {
            h1.setText("Microprocessor");
        }
        else if (subject.equals("TOC")) {
            h1.setText("Theory of Computation");
        }
        else if (subject.equals("IT")) {
            h1.setText("Internet Technologies");
        }
        else if (subject.equals("DAV")) {
            h1.setText("Data Analysis and Visualisation");
        }
        if (type.equals("Assignment1")) {
            d1.setText("Assignment 1 Marks:");
            m1.setText("8");
        }
        else if (type.equals("Assignment2")) {
            d1.setText("Assignment 2 Marks:");
            m1.setText("5");
        }
        else if (type.equals("Assignment3")) {
            d1.setText("Assignment 3 Marks:");
            m1.setText("7");
        }
        else if (type.equals("Assignment4")) {
            d1.setText("Assignment 4 Marks:");
            m1.setText("9");
        }
        else if (type.equals("Assignment5")) {
            d1.setText("Assignment 5 Marks:");
            m1.setText("10");
        }
        else if (type.equals("Internal1")) {
            d1.setText("Internal Assessment 1 Marks:");
            m1.setText("8");
        }
        else if (type.equals("Internal2")) {
            d1.setText("Internal Assessment 2 Marks:");
            m1.setText("9");
        }
        else if (type.equals("Internal3")) {
            d1.setText("Internal Assessment 3 Marks:");
            m1.setText("10");
        }

      /*  Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
*/
    }
}

