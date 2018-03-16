package com.appointment.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.appointment.appointment.logic.Appointment;
import com.appointment.appointment.logic.Business;
import com.appointment.appointment.logic.Client;
import com.appointment.appointment.logic.DbUtils;
import com.appointment.appointment.logic.User;
import com.google.firebase.database.DatabaseReference;
import android.support.design.widget.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String USER_ID = "userId";
    private DatabaseReference reference;
    private String userId;
    Calendar c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    c=Calendar.getInstance();




        userId = DbUtils.getInstance().readFromSharedPref(this, USER_ID);
        if(TextUtils.isEmpty(userId)){
            User user = new User("300481736", "Lital", "Kapon", "0508447486", "litalkapon@gmail.com");
            DbUtils.getInstance().insertUser(user);
            DbUtils.getInstance().saveToSharedPref(this,USER_ID,user.getId());
        }

        if(!DbUtils.getIsFireBaseInitiated()){
            DbUtils.getInstance().initFireBase();
        }

        Business business1=new Business("2112", "Nelly's Hair Salon");
        DbUtils.getInstance().insertBusiness(business1);
        Business business2=new Business("1234", "My Clinic");
        DbUtils.getInstance().insertBusiness(business2);
        Business business3=new Business("9876", "S-Nails");
        DbUtils.getInstance().insertBusiness(business3);

        Client liron=new Client ("064982770","Liron", "Izhaki","0525940238","lironi@gmail.com");
        Client lital=new Client ("300481736", "Lital", "Kapon", "0508447486", "litalkapon@gmail.com");
        DbUtils.getInstance().insertClient(liron);
        DbUtils.getInstance().insertClient(lital);

        Appointment appointment=new Appointment("22.4.18","12:00","13:00",liron, business1,"pending");
        Appointment appointment2=new Appointment("01.01.18","17:00","18:30",liron, business2,"Completed");
        Appointment appointment3=new Appointment("16.3.18","09:00","10:00",lital, business1,"Approved");

        DbUtils.getInstance().insertAppointment(appointment);
        DbUtils.getInstance().insertAppointment(appointment2);
        DbUtils.getInstance().insertAppointment(appointment3);

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

    }




}
