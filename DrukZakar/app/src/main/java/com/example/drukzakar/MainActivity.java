package com.example.drukzakar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tablayoutid);
        viewPager=findViewById(R.id.viewpagerid);

        tabLayout.setupWithViewPager(viewPager);

        VPadapter vpAdapter=new VPadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addfragment(new Date(),"Date");
        vpAdapter.addfragment(new Dzongkha(),"Dzongkha");
        vpAdapter.addfragment(new English(),"English");
        vpAdapter.addfragment(new Audio(),"Audio");
        viewPager.setAdapter(vpAdapter);
    }
}