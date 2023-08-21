package com.example.drukzakar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

public class English extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_english, container, false);

        ViewPager ViewInnerPager = view.findViewById(R.id.fragmentenglishid);

        InnerVPAdapter innerVPAdapter = new InnerVPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        innerVPAdapter.addFragments(new InnerEnglishFragment1(), "Fragment 1");
        innerVPAdapter.addFragments(new InnerEnglishFragment2(), "Fragment 2");

        ViewInnerPager.setAdapter(innerVPAdapter);

        return view;

    }
}