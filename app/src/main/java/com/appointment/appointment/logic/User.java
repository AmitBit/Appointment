package com.appointment.appointment.logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class User implements Serializable{
    String id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    //ContactsContract.CommonDataKinds.Phone phoneNumber;
    //ContactsContract.CommonDataKinds.Email email;


    public User(String id, String firstName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
