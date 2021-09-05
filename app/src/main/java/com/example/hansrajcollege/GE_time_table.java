package com.example.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class GE_time_table extends AppCompatActivity {

    PDFView mPDFview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_e_time_table);
        mPDFview=(PDFView)findViewById(R.id.pdfView_ge);
        mPDFview.fromAsset("ge_tt.pdf").load();
    }
}