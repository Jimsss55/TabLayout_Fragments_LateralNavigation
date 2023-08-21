package com.example.drukzakar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Dzongkha extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        To make xml file visible we use the inflater
        View view=inflater.inflate(R.layout.fragment_dzongkha,container,false);

//        To make the fragments swipeable we make use of the ViewPager
        ViewPager InnerViewPager=view.findViewById(R.id.dzongkhafragmentid);

//        To handle the each fragmennts
        InnerVPAdapter innerVPAdapter=new InnerVPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

//  Adding a fragment to the innerVPAdapter
        innerVPAdapter.addFragments(new InnerDzongkhaFragment1(),"Fragment 1");
        innerVPAdapter.addFragments(new InnerDzongkhaFragment2(),"Fragment 2");

//        Finally the innerViewAdapter is set as the adapter and to enable the lateral navigation
        InnerViewPager.setAdapter(innerVPAdapter);
        return view;
    }
}