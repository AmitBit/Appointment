package com.appointment.appointment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BusinessActivity extends FragmentActivity {

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mScreenSlidePagerAdapter;
    private ViewPager mPager;
    private FloatingActionButton fab;
    private BottomNavigationView mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        mPager = (ViewPager) findViewById(R.id.pager);
        // Instantiate a ViewPager and a PagerAdapter.

        mScreenSlidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mScreenSlidePagerAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

       // fab = findViewById(R.id.fab);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent();
//                intent.setClass(BusinessActivity.this, SelectBusinessActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    clickCalendar();
                    return true;
                case R.id.navigation_dashboard:
                    clickButton2();
                    return true;
                case R.id.navigation_notifications:
                    clickButton3();
                    return true;
            }
            return false;
        }
    };


    public void clickCalendar() {
        //mScreenSlidePagerAdapter.getItemPosition(0);
        mPager.setCurrentItem(0);

    }

    public void clickButton2() {
        mPager.setCurrentItem(1);
    }

    public void clickButton3() {
        mPager.setCurrentItem(0);
        openMainActivity();
    }

    public void openMainActivity(){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }


}
