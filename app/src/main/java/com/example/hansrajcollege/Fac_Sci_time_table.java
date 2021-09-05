package com.example.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Fac_Sci_time_table extends AppCompatActivity {

    PDFView mPDFview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac__sci_time_table);

        mPDFview=(PDFView)findViewById(R.id.pdfView_fac_sci);
        mPDFview.fromAsset("fac_sci_tt.pdf").load();
    }
}