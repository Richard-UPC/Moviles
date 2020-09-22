package com.aranibar.homeservice.viewcontrollers.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.activities.ClientActivity;
import com.aranibar.homeservice.viewcontrollers.activities.ClienteActivity;
import com.aranibar.homeservice.viewcontrollers.activities.LoginActivity;
import com.aranibar.homeservice.viewcontrollers.activities.MainActivity;
import com.aranibar.homeservice.viewcontrollers.activities.SpecialistActivity;
import com.aranibar.homeservice.viewcontrollers.activities.StartActivity;
import com.aranibar.homeservice.viewcontrollers.models.Customer;
import com.aranibar.homeservice.viewcontrollers.networking.responses.GetSpecialistByIdResponse;
import com.aranibar.homeservice.viewcontrollers.networking.responses.GetSpecialistResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Customer customer;
    private View vista;
    ImageButton  editButton;
    Button favoritesButton;
    private SharedPreferences pref;
    private int customerId;
    TextView text_rate;
    TextView text_user;
    TextView text_pwd;
    TextView text_names;
    TextView text_lastnames;
    TextView text_docnumber;
    TextView text_phone;
    TextView text_email;
    TextView text_address;
    TextView text_reference;

    JSONObject body;
    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_profile, container, false);
        text_rate = (TextView) vista.findViewById(R.id.text_rate);
        //text_rate.setText("0");
        text_user = (TextView) vista.findViewById(R.id.text_user);
        text_pwd = (TextView) vista.findViewById(R.id.text_pwd);
        text_names = (TextView) vista.findViewById(R.id.text_names);
        text_lastnames = (TextView) vista.findViewById(R.id.text_lastnames);
        text_docnumber = (TextView) vista.findViewById(R.id.text_docnumber);
        text_phone = (TextView) vista.findViewById(R.id.text_phone);
        text_email = (TextView) vista.findViewById(R.id.text_email);
        text_address = (TextView) vista.findViewById(R.id.text_address);
        text_reference = (TextView) vista.findViewById(R.id.text_reference);


        editButton= (ImageButton) vista.findViewById(R.id.button_edit);
        //return inflater.inflate(R.layout.fragment_profile, container, false);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Context context  = view.getContext();
                    Gson gson = new Gson();
                    String customerJSON = gson.toJson(customer);
                    Intent intent = new Intent(context, ClienteActivity.class);
                    intent.putExtra("customerJSON", customerJSON);
                    startActivity(intent);
                }catch (Exception ex){
                    Log.i("Error activity", ex.getMessage());
                }
            }
        });


        body = new JSONObject();
        //Lee id de usuario de SharedPreferences
        pref = getActivity().getApplicationContext().getSharedPreferences("HomeServicesPref", 0);
        customerId = pref.getInt("customerId", -1);
        Log.d("HomeService", "customerId: " + customerId );
        try {
            Log.d("HomeServices", body.toString());
            //Post a usuarios
            AndroidNetworking.get("https://homeservices-ws.herokuapp.com/api/v1/customers/" + customerId)
                    .setTag("HomeServices")
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsObject(GetSpecialistByIdResponse.class, new ParsedRequestListener<GetSpecialistByIdResponse>() {
                        @Override
                        public void onResponse(GetSpecialistByIdResponse response) {
                            customer = response.getData();
                            text_rate.setText(String.valueOf(response.getData().getRate()));
                            text_user.setText(response.getData().getEmail());
                            text_pwd.setText(response.getData().getPassword());
                            text_names.setText(response.getData().getName());
                            text_lastnames.setText(response.getData().getLastName());
                            text_docnumber.setText(response.getData().getDni());
                            text_phone.setText(response.getData().getNumberPhone());
                            text_email.setText(response.getData().getEmail());
                            text_address.setText(response.getData().getAddress());
                            text_reference.setText(response.getData().getDescription());
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.e("HomeServices", "error:" + anError.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vista;


    }
}