package com.appointment.appointment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Liron on 15/03/2018.
 */

public class BusinessListAdapter extends RecyclerView.Adapter<BusinessListAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameOfBusiness,date;
        public ImageView img;

        public ViewHolder (View view){
            super(view);
            nameOfBusiness=view.findViewById(R.id.li_business_name);
            date=view.findViewById(R.id.li_appointment_date_time);
            img=view.findViewById(R.id.li_business_img);


        }



    }
}
