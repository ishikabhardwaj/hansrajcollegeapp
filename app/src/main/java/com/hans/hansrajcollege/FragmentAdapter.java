package com.hans.hansrajcollege;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new Login_fragment();
            case 1: return new Syllabus_fragment();
            case 2: return new TImeTable_fragment();

            default: return new Login_fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title= null;
        if(position==0)
        {
            title= "LOGIN";
        }
        else if(position==1)
        {
            title= "SYLLABUS";
        }
        else if(position==2)
        {
            title= "TIME TABLE";
        }
        return title;
    }

}
