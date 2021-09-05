package com.example.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class arts_comm_time_table extends AppCompatActivity {

    PDFView mPDFview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_comm_time_table);

        mPDFview=(PDFView)findViewById(R.id.pdfView_arts_comm);
        mPDFview.fromAsset("arts_comm_tt.pdf").load();
    }
}