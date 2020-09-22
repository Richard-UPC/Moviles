package com.aranibar.homeservice.viewcontrollers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.networking.responses.GetSpecialistResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private Button registerButton;
    private Button loginButton;
    private EditText username;
    private EditText password;
    private SharedPreferences pref;
    JSONObject body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.button_login);
        registerButton = (Button) findViewById(R.id.button_register_client);
        body = new JSONObject();

        pref = getApplicationContext().getSharedPreferences("HomeServicesPref", 0);
        final SharedPreferences.Editor prefEdit = pref.edit();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context  = view.getContext();
                //Intent intent = new Intent(context, RegisterActivity.class);
                Intent intent = RegisterActivity.makeIntent(LoginActivity.this);
                startActivity(intent);
                //startActivity(new Intent(context, RegisterActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Context context  = view.getContext();
                //startActivity(new Intent(context, StartActivity.class));
                try {

                    username = (EditText) findViewById(R.id.text_user);
                    password = (EditText) findViewById(R.id.text_pwd);
                    body.put("email", username.getText());
                    body.put("password", password.getText());
                    Log.d("HomeServices", body.toString());
                    //Post a usuarios
                    AndroidNetworking.post("https://homeservices-ws.herokuapp.com/api/v1/login")
                            .addJSONObjectBody(body)
                            .setTag("HomeServices")
                            .setPriority(Priority.MEDIUM)
                            .build()
                           .getAsObject(GetSpecialistResponse.class, new ParsedRequestListener<GetSpecialistResponse>() {
                               @Override
                               public void onResponse(GetSpecialistResponse response) {
                                   Log.d("HomeServices", "size of array:" + String.valueOf(response.getData().size()));
                                   if(response.getData().size() <=0){
                                       Toast.makeText(LoginActivity.this,"Usuario y/o contraseña incorrectas", Toast.LENGTH_SHORT).show();
                                   }else{
                                       prefEdit.putInt("customerId", response.getData().get(0).getId());
                                       prefEdit.commit();
                                       if(response.getData().get(0).getType() == 0){
                                           startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                       }else{
                                           startActivity(new Intent(LoginActivity.this, SpecialistActivity.class));
                                       }
                                   }
                               }

                               @Override
                               public void onError(ANError anError) {
                                    Log.e("HomeServices", "error:" + anError.getMessage());
                               }
                           });

            } catch (JSONException e) {
                e.printStackTrace();
            }


            }
        });

    }
}