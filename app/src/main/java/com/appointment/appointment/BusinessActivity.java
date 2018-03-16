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

import com.appointment.appointment.logic.Appointment;
import com.appointment.appointment.logic.Business;
import com.appointment.appointment.logic.Client;
import com.appointment.appointment.logic.DbUtils;

import java.util.ArrayList;

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

        Business business1=new Business("2112", "Nelly's Hair Salon", getResources().getDrawable(R.drawable.hair_salon));
        //  DbUtils.getInstance().insertBusiness(business1);
        Business business2=new Business("1234", "My Clinic",getResources().getDrawable(R.drawable.clinic));
        //  DbUtils.getInstance().insertBusiness(business2);
        Business business3=new Business("9876", "S-Nails",getResources().getDrawable(R.drawable.nails));
        //  DbUtils.getInstance().insertBusiness(business3);

        Client liron=new Client ("064982770","Liron", "Izhaki","0525940238","lironi@gmail.com");
        Client lital=new Client ("300481736", "Lital", "Kapon", "0508447486", "litalkapon@gmail.com");
        //  DbUtils.getInstance().insertClient(liron);
        //   DbUtils.getInstance().insertClient(lital);

        Appointment appointment=new Appointment("22.4.18","12:00","13:00",liron, business1,"pending");
        Appointment appointment2=new Appointment("01.01.18","17:00","18:30",liron, business2,"Completed");
        Appointment appointment3=new Appointment("16.3.18","09:00","10:00",lital, business1,"Approved");

        //  DbUtils.getInstance().insertAppointment(appointment);
        //  DbUtils.getInstance().insertAppointment(appointment2);
        //  DbUtils.getInstance().insertAppointment(appointment3);

        ArrayList<Business> businessList=new ArrayList<Business>();
        businessList.add(business1);
        businessList.add(business2);
        businessList.add(business3);

        ArrayList<Appointment> appointmentsList=new ArrayList<Appointment>();
        appointmentsList.add(appointment);
        appointmentsList.add(appointment2);
        appointmentsList.add(appointment3);

        liron.setRegisteredBusinesses(businessList);
        liron.setClientAppointments(appointmentsList);

        DbUtils.getInstance().setClient(liron);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

       /* fab = findViewById(R.id.fab);

       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent();
                intent.setClass(BusinessActivity.this, SelectBusinessActivity.class);
                startActivity(intent);
           }
        });*/
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
        intent.setClass(this, SelectBusinessActivity.class);
        startActivity(intent);
    }


}
