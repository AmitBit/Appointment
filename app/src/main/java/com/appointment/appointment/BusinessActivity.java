package com.appointment.appointment;


import android.app.Activity;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class BusinessActivity extends FragmentActivity {

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mScreenSlidePagerAdapter;
    private ViewPager mPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        mPager = (ViewPager) findViewById(R.id.pager);
        // Instantiate a ViewPager and a PagerAdapter.

        mScreenSlidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mScreenSlidePagerAdapter);
    }

    public void clickCalendar(View view) {
        //mScreenSlidePagerAdapter.getItemPosition(0);
        mPager.setCurrentItem(0);

    }

    public void clickButton2(View view) {
        mPager.setCurrentItem(1);
    }

    public void clickButton3(View view) {
        mPager.setCurrentItem(0);
    }


}
