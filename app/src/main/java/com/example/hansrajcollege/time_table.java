package com.example.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class time_table extends AppCompatActivity {
    Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        button1=(Button)findViewById(R.id.science_tt);
        button2=(Button)findViewById(R.id.arts_com_tt);
        button3=(Button)findViewById(R.id.ge_tt);
        button4=(Button)findViewById(R.id.fac_sci_tt);
        button5=(Button)findViewById(R.id.fac_art_comm_tt);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getBaseContext(),science_time_table.class);
                startActivity(intent1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getBaseContext(),arts_comm_time_table.class);
                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getBaseContext(),GE_time_table.class);
                startActivity(intent3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getBaseContext(),Fac_Sci_time_table.class);
                startActivity(intent4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(getBaseContext(),Fac_Art_Comm_time_table.class);
                startActivity(intent5);
            }
        });

    }
}