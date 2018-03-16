package com.appointment.appointment.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appointment.appointment.R;
import com.appointment.appointment.logic.Appointment;
import com.appointment.appointment.logic.Business;
import com.appointment.appointment.logic.Client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Liron on 15/03/2018.
 */

public class BusinessListAdapter extends RecyclerView.Adapter<BusinessListAdapter.ViewHolder> {

    private Client client;
    final Calendar c=Calendar.getInstance();
    public BusinessListAdapter (Client client){
        this.client = client;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.li_business,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Business business=client.getRegisteredBusinesses().get(position);
        final  Appointment appointment = getClosestAppointment(business);
        holder.nameOfBusiness.setText(business.getBusinessName());
        Date appointmentDate=appointment.getAppointmentDate();
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yy");
        String appointmentDateString=dateFormat.format(appointmentDate);
        Date today=c.getTime();
        if (today.before(appointmentDate)||today==appointmentDate){
           holder.label.setText("Next Appointment: ");
        }
        else  {
        holder.label.setText("Last Appointment: ");
        }
        holder.date.setText(appointmentDateString);
        holder.img.setImageDrawable((appointment.getBusiness().getImg()));
    }

    private Appointment getClosestAppointment(Business business) {
        Appointment closestAppointment = null;
        for (Appointment appointment: client.getAppointmentsByBusinessMap().get(business)) {
            if(closestAppointment == null){
                closestAppointment = appointment;
            }else if (closestAppointment.getStartTime().after(appointment)){
                closestAppointment = appointment;
            }
        }

        return closestAppointment;
    }

    @Override
    public int getItemCount() {
        return client.getRegisteredBusinesses().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameOfBusiness,date, label;
        public ImageView img;

        public ViewHolder (View view){
            super(view);
            nameOfBusiness=view.findViewById(R.id.li_business_name);
            date=view.findViewById(R.id.li_appointment_date_time);
            label=view.findViewById(R.id.li_appointment_date_time_label);
            img=view.findViewById(R.id.li_business_img);


        }



    }
}
