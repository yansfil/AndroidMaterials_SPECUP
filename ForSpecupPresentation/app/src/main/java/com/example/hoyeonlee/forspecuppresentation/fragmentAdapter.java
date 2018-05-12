package com.example.hoyeonlee.forspecuppresentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hoyeonlee on 2018. 3. 27..
 */

public class fragmentAdapter extends FragmentPagerAdapter{
    public fragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                System.out.println("1번");
                return new fragment1();
            case 1:
                System.out.println("2번");
                return new fragment2();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "fragment" + position;
    }
}
