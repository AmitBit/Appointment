package com.appointment.appointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.appointment.appointment.Adapters.BusinessListAdapter;
import com.appointment.appointment.logic.Business;
import com.appointment.appointment.logic.Client;

import java.util.List;

public class SelectBusinessActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_business);
    }

    public void initRecyclerView (){
        mRecyclerView = findViewById(R.id.businessRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
<<<<<<< HEAD
        Client client = new Client();
       mAdapter = new BusinessListAdapter(client);
=======
     //  mAdapter = new BusinessListAdapter();
>>>>>>> 250707b22394d89271db9f4c0dff2b094d09f54a
        mRecyclerView.setAdapter(mAdapter);


    }
}
