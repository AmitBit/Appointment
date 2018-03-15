package com.appointment.appointment.logic;

import java.util.List;

/**
 * Created by AmitBit on 3/15/2018.
 */

class Client extends User{
    List<Appointment> clientAppointments;
    List<Business> registeredBusinesses;

    public List<Appointment> getClientAppointments() {
        return clientAppointments;
    }

    public void setClientAppointments(List<Appointment> clientAppointments) {
        this.clientAppointments = clientAppointments;
    }

    public List<Business> getRegisteredBusinesses() {
        return registeredBusinesses;
    }

    public void setRegisteredBusinesses(List<Business> registeredBusinesses) {
        this.registeredBusinesses = registeredBusinesses;
    }
}
