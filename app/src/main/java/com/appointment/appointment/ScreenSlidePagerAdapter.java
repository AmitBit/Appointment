package com.appointment.appointment;


//import android.app.Fragment;
//import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by Lital Kapon on 3/15/2018.
 */

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 3;

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {

            case 0: return new ScreenSlidePageFragment();
            case 1: return new ScreenSlidePageFragment2();
            /*case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
            case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
            case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");*/
            default: return new ScreenSlidePageFragment();

        }
        //return new ScreenSlidePageFragment();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
