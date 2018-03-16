package com.appointment.appointment.logic;

import com.appointment.appointment.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AmitBit on 3/15/2018.
 */

public class Client extends User{
    List<Appointment> clientAppointments;
    List<Business> registeredBusinesses;
    private Map<Business, List<Appointment>> appointmentsByBusinessMap;

    public Map<Business, List<Appointment>> getAppointmentsByBusinessMap() {
        if (appointmentsByBusinessMap == null) {
            appointmentsByBusinessMap = new HashMap<>();
        }
        return appointmentsByBusinessMap;
    }

    public Client() {
    }

    public Client(String id, String firstName, String lastName, String phoneNumber, String email, List<Appointment> clientAppointments, List<Business> registeredBusinesses) {
        super(id, firstName, lastName, phoneNumber, email);
        this.clientAppointments = clientAppointments;
        this.registeredBusinesses = registeredBusinesses;
    }

    public Client(List<Appointment> clientAppointments, List<Business> registeredBusinesses) {
        this.clientAppointments = clientAppointments;
        this.registeredBusinesses = registeredBusinesses;
    }

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
