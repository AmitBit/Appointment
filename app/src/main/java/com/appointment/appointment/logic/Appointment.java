package com.appointment.appointment.logic;

import com.appointment.appointment.logic.enums.Status;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class Appointment {
 //  Calendar startTime;
   // Calendar endTime;
    String startTime;
    String endTime;
    Client client;
    Business business;
    String status;
    String date;



    public Appointment() {
    }

    public Appointment(String date, String startTime, String endTime, Client client, Business business, String status) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.business = business;
        this.status = status;
        this.date=date;
    }

    public String getAppointmentDate() {

        return date;
    }

   /* public Calendar getStartTime() {
        return startTime;
    }*/

   public String getStartTime(){
       return startTime;
    }

    /*public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }*/
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /*public Calendar getEndTime() {
        return endTime;
    }*/

    public String getEndTime() {
        return endTime;
    }

    /*public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }*/
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
