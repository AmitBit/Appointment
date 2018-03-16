package com.appointment.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.appointment.appointment.logic.DbUtils;
import com.appointment.appointment.logic.User;
import com.google.firebase.database.DatabaseReference;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String USER_ID = "userId";
    private DatabaseReference reference;
    private String userId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        userId = DbUtils.getInstance().readFromSharedPref(this, USER_ID);
        if(TextUtils.isEmpty(userId)){
            User user = new User("300481736", "Lital", "Kapon", "0508447486", "litalkapon@gmail.com");
            DbUtils.getInstance().insertUser(user);
            DbUtils.getInstance().saveToSharedPref(this,USER_ID,user.getId());
        }

        if(!DbUtils.getIsFireBaseInitiated()){
            DbUtils.getInstance().initFireBase();
        }


    }




}
