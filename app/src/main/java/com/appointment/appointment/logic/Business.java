package com.appointment.appointment.logic;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class Business {
    String id;
    User businessOwner;
    String businessName;
    List<Client> clients;
    Drawable businessImg;
    List<Appointment> clientsRequests;

    public Business (){}

    public Business (String idNum, String name, Drawable photo){

        id=idNum;
        businessName=name;
        businessImg=photo;
    }
    public Business (String idNum, String name){

        id=idNum;
        businessName=name;

    }


    public Business(String id, User businessOwner, String businessName, List<Client> clients, Drawable businessImg) {
        this.id = id;
        this.businessOwner = businessOwner;
        this.businessName = businessName;
        this.clients = clients;
        this.businessImg = businessImg;
    }



    public List<Appointment> getClientsRequests() {
        if(clientsRequests == null){
            clientsRequests = new ArrayList<>();
        }
        return clientsRequests;
    }

    public void setClientsRequests(List<Appointment> clientsRequests) {
        this.clientsRequests = clientsRequests;
    }

    Map<Client,List<Appointment>> clientAppointmentsRequests;

    public Drawable getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(Drawable businessImg) {
        this.businessImg = businessImg;
    }

    public Map<Client, List<Appointment>> getClientAppointmentsRequests() {
        if(clientAppointmentsRequests == null){
            clientAppointmentsRequests =  new HashMap<>();
        }
        return clientAppointmentsRequests;
    }

    public void setClientAppointmentsRequests(Map<Client, List<Appointment>> clientAppointmentsRequests) {
        this.clientAppointmentsRequests = clientAppointmentsRequests;
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
