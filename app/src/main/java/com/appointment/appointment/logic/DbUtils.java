package com.appointment.appointment.logic;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Lital Kapon on 3/16/2018.
 */

public class DbUtils {
    public static final String DB_USER = "users";
    public static final String DB_CLIENT = "clients";
    public static final String DB_BUSINESS = "business";
    public static final String DB_APPOINTMENT = "appointment";

    private static DbUtils dbUtils;
    private DatabaseReference reference;

    private DbUtils() {
        this.reference = FirebaseDatabase.getInstance().getReference();
    }

    // Need to lock
    public static DbUtils getInstance(){
        if(dbUtils != null){
            dbUtils = new DbUtils();
        }

        return dbUtils;
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
}
