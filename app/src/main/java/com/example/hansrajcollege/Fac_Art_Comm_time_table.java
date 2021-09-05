package com.example.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Fac_Art_Comm_time_table extends AppCompatActivity {

    PDFView mPDFview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac__art__comm_time_table);

        mPDFview=(PDFView)findViewById(R.id.pdfView_fac_arts_comm);
        mPDFview.fromAsset("fac_arts_comm_tt.pdf").load();
    }
}