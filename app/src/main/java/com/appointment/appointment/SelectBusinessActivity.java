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
        initRecyclerView();
    }

    public void initRecyclerView (){
        mRecyclerView = findViewById(R.id.businessRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Client client = new Client();
       mAdapter = new BusinessListAdapter(client);
        mRecyclerView.setAdapter(mAdapter);
    }
}
