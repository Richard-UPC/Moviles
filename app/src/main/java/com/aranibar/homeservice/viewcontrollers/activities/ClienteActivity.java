package com.aranibar.homeservice.viewcontrollers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.models.Customer;
import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;

import org.json.JSONException;
import org.json.JSONObject;

public class ClienteActivity extends AppCompatActivity {
    private Customer customer;
    private Button register;
    private EditText username;
    private EditText password;
    private EditText firstname;
    private EditText lastname;
    private EditText dni;
    private EditText phone;
    private EditText email;
    private EditText address;
    private Button updateBtn;
    JSONObject body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson customerJSON = new Gson();
        customer = customerJSON.fromJson(getIntent().getStringExtra("customerJSON"), Customer.class);
        Log.d("HomeServices", "This is a customer name: " + customer.getName());

        setContentView(R.layout.activity_cliente);
        updateBtn = (Button) findViewById(R.id.button_update);
        username = (EditText) findViewById(R.id.text_user);
        username.setText(customer.getEmail());
        password = (EditText) findViewById(R.id.text_pwd);
        password.setText(customer.getPassword());
        firstname = (EditText) findViewById(R.id.text_names);
        firstname.setText(customer.getName());
        lastname = (EditText) findViewById(R.id.text_lastnames);
        lastname.setText(customer.getLastName());
        dni = (EditText) findViewById(R.id.text_docnumber);
        dni.setText(customer.getDni());
        phone = (EditText) findViewById(R.id.text_phone);
        phone.setText(customer.getNumberPhone());
        email = (EditText) findViewById(R.id.text_email);
        email.setText(customer.getEmail());
        address = (EditText) findViewById(R.id.text_address);
        address.setText(customer.getAddress());
        Log.d("HomeService", "customerId:" + customer.getId());
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    body.put("email", email.getText());
                    body.put("password", password.getText());
                    body.put("name", firstname.getText());
                    body.put("lastName", lastname.getText());
                    body.put("dni", dni.getText());
                    body.put("numberPhone", phone.getText());
                    body.put("address", address.getText());
                    body.put("districtId", 21);
                    body.put("specialtyId", 1);
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }

                AndroidNetworking.put("http://homeservices-ws.herokuapp.com/api/v1/customers/" + customer.getId())
                        .addJSONObjectBody(body)
                        .setTag("HomeServices")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("Post Succes:", response.toString());
                            }
                            @Override
                            public void onError(ANError anError) {
                                Log.e("HomeServices", anError.getMessage());
                            }
                        });
            }
        });
    }
}