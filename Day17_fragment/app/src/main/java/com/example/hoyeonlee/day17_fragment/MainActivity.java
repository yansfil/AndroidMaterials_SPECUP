package com.example.hoyeonlee.day17_fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//    Button profileButton;
//    Button fruitButton;
//    FragmentManager fragmentManager;
//    FruitFragment fruitFragment;
//    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    //TODO Framelayout + Fragment로 구현하기
//        profileButton = findViewById(R.id.btn_profile);
//        fruitButton = findViewById(R.id.btn_fruit);
//
//        //Fragment 객체 생성
//        profileFragment = new ProfileFragment();
//        fruitFragment = new FruitFragment();
//
//        //FrameLayout에 fragment를 넣게 해주는 FragmentManager 생성
//        fragmentManager = getSupportFragmentManager();
//
//
//        profileButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                //framelayout에다가 fragment를 넣어주는 작업
//                transaction.replace(R.id.framelayout,profileFragment);
//                transaction.commit();
//            }
//        });
//
//        fruitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                //framelayout에다가 fragment를 넣어주는 작업
//                transaction.replace(R.id.framelayout,fruitFragment);
//                transaction.commit();
//            }
//        });
}
