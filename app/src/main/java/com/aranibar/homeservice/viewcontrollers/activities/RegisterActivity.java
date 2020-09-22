package com.aranibar.homeservice.viewcontrollers.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.models.Specialty;
import com.aranibar.homeservice.viewcontrollers.networking.responses.GetSpecialistResponse;
import com.aranibar.homeservice.viewcontrollers.networking.responses.GetSpecialtyResponse;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
    private Button button_register;
    private TextView mTextView;
    private List<Specialty> specialties;
    private List<String> specialtyNames;
    ArrayAdapter<String> specialtiesAdapter;
    Spinner specialtiesSpinner;


    private Button register;
    private EditText username;
    private EditText password;
    private EditText firstname;
    private EditText lastname;
    private EditText dni;
    private EditText phone;
    private EditText email;
    private EditText address;
    private ImageButton addPhoto;
    private static final int REQUEST_CODE = 101;
    JSONObject body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupEndActivityButton();

        username = (EditText) findViewById(R.id.text_user);
        password = (EditText) findViewById(R.id.text_pwd);
        firstname = (EditText) findViewById(R.id.text_names);
        lastname = (EditText) findViewById(R.id.text_lastnames);
        dni = (EditText) findViewById(R.id.text_docnumber);
        phone = (EditText) findViewById(R.id.text_phone);
        email = (EditText) findViewById(R.id.text_email);
        address = (EditText) findViewById(R.id.text_address);

        addPhoto = (ImageButton) findViewById(R.id.button_camera);
        register = (Button) findViewById(R.id.button_register);

        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(view.getContext(), CameraPhoto.class), REQUEST_CODE);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
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

                    Log.d("HomeServices", body.toString());
//Post a usuarios
                    AndroidNetworking.post("http://homeservices-ws.herokuapp.com/api/v1/customers")
                            .addJSONObjectBody(body)
                            .setTag("HomeServices")
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.d("Post Succes:", response.toString());
                                    finish();
                                }
                                @Override
                                public void onError(ANError anError) {
                                    Log.e("HomeServices", anError.getMessage());
                                }
                            });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


        final String[] tipocli = new String[] { "1.Cliente", "2.Especialista" };
        body = new JSONObject();

        specialtyNames = new ArrayList<>();
        specialtiesSpinner = (Spinner) findViewById(R.id.text_docespecial);

        specialtiesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("HomeServices", String.valueOf(i));
                int id = specialties.get(i).getId();
                try {
                    body.put("specialtyId", id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,    android.R.layout.simple_spinner_item, tipocli);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner combo = (Spinner) findViewById(R.id.text_doctype);
        combo.setAdapter(adaptador);

        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                try {
                    body.put("type", position);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(RegisterActivity.this, "Seleccionado: " + tipocli[position], Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(RegisterActivity.this, "No ha seleccionado",    Toast.LENGTH_LONG).show();
            }
        });

        AndroidNetworking.get("http://homeservices-ws.herokuapp.com/api/v1/specialties")
                .setPriority(Priority.LOW)
                .setTag("HomeServices")
                .build()
                .getAsObject(GetSpecialtyResponse.class, new ParsedRequestListener<GetSpecialtyResponse>() {
                    @Override
                    public void onResponse(GetSpecialtyResponse response) {
                        Log.d("HomeServices", String.valueOf(response.getData().size()));
                        specialties = response.getData();
                        specialtyNames = buildListSpecialties(specialties);
                        specialtiesAdapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_item, specialtyNames);
                        specialtiesSpinner.setAdapter(specialtiesAdapter);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("HomeServices", anError.getMessage());
                    }
                });

    }

    private ArrayList<String> buildListSpecialties(List<Specialty> specialties){
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0; i < specialties.size(); i++) {
            arr.add(specialties.get(i).getName());
        }
        return arr;
    };

    private void setupEndActivityButton(){
        mTextView = (TextView) findViewById(R.id.text);
        button_register = (Button) findViewById(R.id.button_register);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context  = view.getContext();
                Toast.makeText(context,"¡Usuario registrado correctamente!",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    public static Intent makeIntent(Context context){
        return new Intent(context,RegisterActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE && data !=null) {
                String photoUrl = data.getStringExtra("photoUrl");
                Log.d("firebase", "photo url from firebase " + photoUrl);
                try {
                    body.put("imgUrl", photoUrl);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}