package com.hans.hansrajcollege;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class TimeTableFragment extends Fragment {
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_timetable, container, false);
        super.onCreate(savedInstanceState);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getActivity(), getActivity().getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
        return root;
    }
}
