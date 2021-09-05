package com.example.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class science_time_table extends AppCompatActivity {
    PDFView mPDFview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_time_table);
        mPDFview=(PDFView)findViewById(R.id.pdfView_science);
        mPDFview.fromAsset("science_tt.pdf").load();
    }
}