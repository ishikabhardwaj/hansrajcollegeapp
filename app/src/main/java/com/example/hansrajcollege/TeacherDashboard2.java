package com.example.hansrajcollege;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.hansrajcollege.models.ApiClient;
import com.example.hansrajcollege.models.logout_request;
import com.example.hansrajcollege.models.logout_respond;
import com.google.android.material.navigation.NavigationView;

import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherDashboard2 extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    TextView userID,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

        //getSupportActionBar().setIcon(R.drawable.ic_baseline_account_circle_24);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        toggle.setHomeAsUpIndicator(R.mipmap.profile_icon);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TeacherDashboard()).commit();
        NavigationView nav = (NavigationView) findViewById(R.id.nav_view);
        View header1 = nav.getHeaderView(0);
        View header2 = nav.getHeaderView(1);



        TextView text = (TextView) header1.findViewById(R.id.username);
        text.setText(pref.getString("name",null));
        TextView userId = (TextView) header1.findViewById(R.id.useremailID);
        userId.setText(pref.getString("uid",null));
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TeacherProfile()).addToBackStack(null).commit();
                        break;
                    case R.id.nav_about :
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.nav_contact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ContactFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.nav_logout:
                        logout();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }


        });
    }

    private void logout() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        logout_request logout_request=new logout_request();
        logout_request.setRefresh(pref.getString("refresh",null));

        Call<logout_respond> log= ApiClient.getUserService(pref.getString("access",null)).logout(logout_request);
        log.enqueue(new Callback<logout_respond>() {
            @Override
            public void onResponse(Call<logout_respond> call, Response<logout_respond> response) {
                if(response.isSuccessful()){
                    //Log.d("response",response.body().getMessage());
                    pref.edit().clear();
                    pref.edit().apply();
                    Intent intent=new Intent(getApplicationContext(), Login_fragment.class);
                    startActivity(intent);
                }
                else {
                    //Log.d("response",response.body().getMessage());

                    Toast.makeText(getApplication(), "Logout failed", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<logout_respond> call, Throwable t) {
                Log.d("response",t.getLocalizedMessage());
                Toast.makeText(getApplication(), "Logout failed", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}