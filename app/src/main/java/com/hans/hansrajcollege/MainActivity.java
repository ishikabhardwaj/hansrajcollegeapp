package com.hans.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private int progress = 0;
    ProgressBar simpleProgressBar;
    Handler phandler= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progress<100){
                    progress++;
                    android.os.SystemClock.sleep(50);
                    phandler.post(new Runnable() {
                        @Override
                        public void run() {
                            simpleProgressBar.setProgress(progress);
                        }
                    });
                }
                phandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(getBaseContext(), Home_page.class);
                        startActivity(intent);
                    }
                });
            }
        }).start();
    }
}