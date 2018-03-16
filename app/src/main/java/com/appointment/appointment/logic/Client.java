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
    private List<Business> registeredBusinesses;
    private Map<Business,List<Appointment>> appointmentsByBusinessMap;

    public Map<Business, List<Appointment>> getAppointmentsByBusinessMap() {
        if(appointmentsByBusinessMap == null){
            appointmentsByBusinessMap = new HashMap<>();
        }
        return appointmentsByBusinessMap;
    }


    public List<Business> getRegisteredBusinesses() {
        if(registeredBusinesses == null){
            createBusinessList();
        }
        return registeredBusinesses;
    }

    public void setRegisteredBusinesses(List<Business> registeredBusinesses) {
        this.registeredBusinesses = registeredBusinesses;
    }

    public void addNewAppointment(Appointment newAppointment){
        addAppointmentToMap(newAppointment);
    }

    public void registerNewBusiness(Business newBusiness){
        getRegisteredBusinesses().add(newBusiness);
    }

    private void createBusinessList(){

        Business business1=new Business("2112","Nelly's Hair Salon", R.drawable.hair_salon );
        Business business2=new Business("4455","MyClininc", );
        Business business3=new Business("9876","SNails",);


        registeredBusinesses = new ArrayList<Business>();
        registeredBusinesses.add(business1);
        registeredBusinesses.add(business2);
        registeredBusinesses.add(business3);
        setRegisteredBusinesses(registeredBusinesses);
    }

    private void setAppointmentsByBusinessMap(Map<Business, List<Appointment>> appointmentsByBusinessMap){
        this.appointmentsByBusinessMap = appointmentsByBusinessMap;
    }

    private void addAppointmentToMap(Appointment appointment) {
        if(getAppointmentsByBusinessMap().get(appointment.getBusiness()) == null){
            List<Appointment> appointments = new ArrayList<>();
            appointments.add(appointment);
            getAppointmentsByBusinessMap().put(appointment.getBusiness(), appointments);
        }else{
            getAppointmentsByBusinessMap().get(appointment.getBusiness()).add(appointment);
        }
    }
}
