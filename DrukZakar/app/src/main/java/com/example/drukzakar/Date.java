package com.example.drukzakar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Date extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_date, container,false);

        ViewPager innerViewPager=view.findViewById(R.id.fragmentdateid);
//        InnerVPAdapter innerAdapter=new InnerVPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        InnerVPAdapter innerAdapter=new InnerVPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

//        Add inner fragments to the innerAdapter using addFragment()
        innerAdapter.addFragments(new InnerDateFragment1(),"Inner Fragment 1");
        innerAdapter.addFragments(new InnerDateFragment2(),"Inner Fragment 1");

        innerViewPager.setAdapter(innerAdapter);


        return view;
    }
}