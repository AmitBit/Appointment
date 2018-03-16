package com.appointment.appointment.logic;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lital Kapon on 3/16/2018.
 */

public class DbUtils {
    public static final String DB_USER = "users";
    public static final String DB_CLIENT = "clients";
    public static final String DB_BUSINESS = "business";
    public static final String DB_APPOINTMENT = "appointment";

    private static DbUtils dbUtils;


    private static Boolean isFireBaseInitiated = false;
    private DatabaseReference reference;

    private DbUtils() {
        this.reference = FirebaseDatabase.getInstance().getReference();
    }

    // Need to lock
    public static DbUtils getInstance(){
        if(dbUtils == null){
            dbUtils = new DbUtils();
        }

        return dbUtils;
    }

    public static Boolean getIsFireBaseInitiated() {
        return isFireBaseInitiated;
    }

    /*reference = FirebaseDatabase.getInstance().getReference();
    User user = new User("300481736", "Lital", "Kapon", "0508447486", "litalkapon@gmail.com");
        reference.child("users").push().setValue(user);*/
    
    public void insertUser(User user){
        reference.child(DB_USER).push().setValue(user);
    }

    public void insertClient(Client client){
        reference.child(DB_CLIENT).push().setValue(client);
    }

    public void insertBusiness(Business business){
        reference.child(DB_BUSINESS).push().setValue(business);
    }

    public void insertAppointment(Appointment appointment){
        reference.child(DB_APPOINTMENT).push().setValue(appointment);
    }

    public void saveToSharedPref(Activity activity, String key, String data){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, data);
        editor.commit();
    }

    public String readFromSharedPref(Activity activity, String key){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        String result = sharedPref.getString(key, "");
        return result;
    }

    public  void initFireBase() {
        reference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                new AsyncTask<DataSnapshot, Void, Void>() {
                    @Override
                    protected Void doInBackground(DataSnapshot... dataSnapshots) {
                        isFireBaseInitiated = true;
                        for (DataSnapshot child: dataSnapshot.getChildren()) {
                            Log.i("MyTag", child.getValue().toString());
                            User user = child.getValue(User.class);
                            Log.i("MyTag", user.getFirstName());
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {

                    }
                }.execute(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public List<Appointment> getBusinessAppointment(int businessId){
        reference.child(DB_APPOINTMENT).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                new AsyncTask<DataSnapshot, Void, List<Appointment>>() {
                    @Override
                    protected List<Appointment> doInBackground(DataSnapshot... dataSnapshots) {
                        List<Appointment> appointmentList = new ArrayList<>();
                        for (DataSnapshot data: dataSnapshot.getChildren()) {
                            Appointment appointment = data.getValue(Appointment.class);
                            appointmentList.add(appointment);
                            /*if(appointment.getKey().equals(Email.encodeID(email))){
                                retrievedUser = messageSnapshot.getValue(User.class);
                                break;
                            }*/
                        }

                        return appointmentList;
                    }

                }.execute(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return null;
    }
}
