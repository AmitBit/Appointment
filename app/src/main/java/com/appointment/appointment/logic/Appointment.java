package com.appointment.appointment.logic;

import com.appointment.appointment.logic.enums.Status;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class Appointment {
    Calendar startTime;
    Calendar endTime;
    Client client;
    Business business;
    Status status;

    public Business getBusiness(){
        return business;
    }

    public Date getAppointmentDate(){

        return startTime.getTime();
    }
}
