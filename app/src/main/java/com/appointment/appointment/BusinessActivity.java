package com.appointment.appointment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
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
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        mPager = (ViewPager) findViewById(R.id.pager);
        // Instantiate a ViewPager and a PagerAdapter.

        mScreenSlidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mScreenSlidePagerAdapter);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent();
                intent.setClass(BusinessActivity.this,SelectBusinessActivity.class);
                startActivity(intent);
            }
        });
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
        openMainActivity();
    }

    public void openMainActivity(){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }


}
