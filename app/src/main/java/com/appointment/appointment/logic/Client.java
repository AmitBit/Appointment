package com.appointment.appointment.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class Client extends User{
    List<Appointment> clientAppointments;
    List<Business> registeredBusinesses;

    public List<Appointment> getClientAppointments() {
        if(clientAppointments == null){
            clientAppointments = new ArrayList<>();
        }
        return clientAppointments;
    }

    public void setClientAppointments(List<Appointment> clientAppointments) {
        this.clientAppointments = clientAppointments;
    }

    public List<Business> getRegisteredBusinesses() {
        if(registeredBusinesses == null){
            registeredBusinesses = new ArrayList<>();
        }
        return registeredBusinesses;
    }

    public void setRegisteredBusinesses(List<Business> registeredBusinesses) {
        this.registeredBusinesses = registeredBusinesses;
    }

    public void addNewAppointment(Appointment newAppointment){
        getClientAppointments().add(newAppointment);
    }

    public void registerNewBusiness(Business newBusiness){
        getRegisteredBusinesses().add(newBusiness);
    }
}
