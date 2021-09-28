package com.example.hansrajcollege;

import android.icu.text.Edits;
import android.os.Bundle;
import android.app.Activity;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //will return inflater.inflate(R.layout.fragment_profile, container, false) at the end
        View view =   inflater.inflate(R.layout.fragment_profile,container,false);

        String namelist[] = {"USERNAME", "PASSWORD", "NAME", "ROLL NUMBER", "COURSE", "SEMESTER"};
        String valuelist[] = {"benika8162","abc#123","Benika Yadav","8162","B.Sc(hons)-Computer Science","5"};

        ListView profilelist=(ListView) view.findViewById(R.id.profilelist);
        HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the profile list items in key value pair
        for(int i=0;i<namelist.length;i++) {
            hashMap.put(namelist[i],valuelist[i]);
        }
        List<HashMap<String,String>> listitems=new ArrayList<>();

        listitems.add(hashMap);//add the hashmap into arrayList

        String[] from={"Heading","value"};//string array
        int[] to={R.id.text1,R.id.text2};//int array of views id's
        SimpleAdapter adapter=new SimpleAdapter(getContext(),listitems,R.layout.profile_listitems, from,to);//Create object and set the parameters for simpleAdapter

        Iterator it=hashMap.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap<String,String> resultMap=new HashMap<>();
            Map.Entry pair=(Map.Entry)it.next();
            resultMap.put("Heading",pair.getKey().toString());
            resultMap.put("value",pair.getValue().toString());
            listitems.add(resultMap);
        }
        profilelist.setAdapter(adapter);//sets the adapter for listView

        return view;
    }

    public void onBackPressed(){
        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

}