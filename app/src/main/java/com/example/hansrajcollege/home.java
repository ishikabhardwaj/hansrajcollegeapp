package com.example.hansrajcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

public class home extends AppCompatActivity {
    int[] sampleImages = {R.drawable.bc1, R.drawable.bc2, R.drawable.bc3};
    String[] btn_text={"Login","View Syllabus","View Time Table"};
    String[] desc={"Login with the credentials provided to get access to more features ",
            "View the entire syllabus of all the courses by clicking this link ",
            "View the Time Table for all the courses by clicking this link "};
    String[] heading={"LOGIN","SYLLABUS","TIME TABLE"};
    CarouselView customCarouselView;
    int NUMBER_OF_PAGES = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        customCarouselView = (CarouselView) findViewById(R.id.carouselView);
        customCarouselView.setPageCount(NUMBER_OF_PAGES);
        customCarouselView.setViewListener(viewListener);
    }

    ViewListener viewListener=new ViewListener() {
        @Override
        public View setViewForPosition(int position) {
            View cs = getLayoutInflater().inflate(R.layout.custom, null);
            ImageView img=(ImageView)cs.findViewById(R.id.image);
            TextView head_text=(TextView)cs.findViewById(R.id.heading_text);
            TextView body_text=(TextView)cs.findViewById(R.id.body_text);
            Button btn=(Button)cs.findViewById(R.id.bttn);
            btn.setText(btn_text[position]);
            img.setImageResource(sampleImages[position]);
            head_text.setText(heading[position]);
            body_text.setText(desc[position]);



            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btn.getText()=="Login"){
                        Intent intent=new Intent(getBaseContext(),login.class);
                        startActivity(intent);
                    }
                    if (btn.getText()=="View Syllabus"){
                        Intent intent=new Intent(getBaseContext(),syllabus.class);
                        startActivity(intent);
                    }
                    if (btn.getText()=="View Time Table"){
                        Intent intent=new Intent(getBaseContext(),time_table.class);
                        startActivity(intent);
                    }


                }
            });


            return cs;
        }
    };
}