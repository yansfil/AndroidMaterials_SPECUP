package com.example.hoyeonlee.day17_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hoyeonlee on 2018. 3. 27..
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    //Viewpager에 들어갈 Fragment를 넣어준다.
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            ProfileFragment fragment = new ProfileFragment();
            return fragment;
        }else if(position == 1){
            FruitFragment fragment = new FruitFragment();
            return fragment;
        }else{
            PokemonFragment fragment = new PokemonFragment();
            return fragment;
        }
    }

    //Tab의 이름을 달아준다.
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "프로필";
        }else if(position == 1){
            return "과일";
        }else{
            return "포켓몬";
        }
    }
}























