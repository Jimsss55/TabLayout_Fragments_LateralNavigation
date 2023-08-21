package com.example.drukzakar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Audio extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_audio,container,false);

        ViewPager InnerViewPager=view.findViewById(R.id.audiofragmentid);
        InnerVPAdapter InnerAdapter=new InnerVPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        InnerAdapter.addFragments(new InnerAudioFragment1(),"Fragment 1");
        InnerAdapter.addFragments(new InnerAudioFragment2(),"Fragment 2");

        InnerViewPager.setAdapter(InnerAdapter);

        return view;
    }
}