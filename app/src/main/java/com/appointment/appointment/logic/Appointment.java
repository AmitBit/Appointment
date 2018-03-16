package com.appointment.appointment.logic;

import com.appointment.appointment.logic.enums.Status;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class Appointment implements Serializable {
    Calendar startTime;
    Calendar endTime;
    Client client;
    Business business;
    Status status;

    public Appointment() {
    }

    public Appointment(Calendar startTime, Calendar endTime, Client client, Business business, Status status) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.business = business;
        this.status = status;
    }

    public Date getAppointmentDate() {

        return startTime.getTime();
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
