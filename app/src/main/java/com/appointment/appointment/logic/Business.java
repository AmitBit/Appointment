package com.appointment.appointment.logic;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class Business {
    String id;
    User businessOwner;
    String businessName;
    List<Client> clients;
    Drawable businessImg;

    public Business (){}
    public Business (String idNum, String name, Drawable photo){

        id=idNum;
        businessName=name;
        businessImg=photo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(User businessOwner) {
        this.businessOwner = businessOwner;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Drawable getImg() {
        return businessImg;
    }
}
