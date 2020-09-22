package com.aranibar.homeservice.viewcontrollers.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.adapters.SpecialistAdapter;
import com.aranibar.homeservice.viewcontrollers.models.Customer;
import com.aranibar.homeservice.viewcontrollers.networking.responses.GetSpecialistResponse;

import java.util.ArrayList;
import java.util.List;


public class SpecialistFragment extends Fragment {
    private RecyclerView recyclerView;
    private SpecialistAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Customer> customers;

    public SpecialistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_specialist, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.specialistRecyclerView);
        recyclerView.setHasFixedSize(true);
        Log.d("HomeServices", "here fragment_specialist!");
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        customers = new ArrayList<Customer>();
        mAdapter = new SpecialistAdapter(customers);
        recyclerView.setAdapter(mAdapter);

        AndroidNetworking.get("http://homeservices-ws.herokuapp.com/api/v1/customers")
                .setPriority(Priority.LOW)
                .setTag("HomeServices")
                .build()
                .getAsObject(GetSpecialistResponse.class, new ParsedRequestListener<GetSpecialistResponse>() {
                    @Override
                    public void onResponse(GetSpecialistResponse response) {
                        Log.d("HomeServices", String.valueOf(response.getData().size()));
                        customers = response.getData();
                        mAdapter.setCustomers(customers);
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("HomeServices", anError.getMessage());
                    }
                });


        return view;
    }
}