package com.example.hoyeonlee.forspecuppresentation;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Day18Activity extends AppCompatActivity {

    TabLayout sliding_tab;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day18);
        sliding_tab = (TabLayout) findViewById(R.id.tabLayout);
        pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new fragmentAdapter(getSupportFragmentManager()));
        sliding_tab.setupWithViewPager(pager);
    }
}
