package com.aranibar.homeservice.viewcontrollers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.aranibar.homeservice.R;
//import com.aranibar.homeservice.viewcontrollers.models.Specialist;
import com.aranibar.homeservice.viewcontrollers.models.Client;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class SpecialistActivity extends AppCompatActivity {

    ViewHolder holder;
    private SharedPreferences pref;
    private int customerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist);
        /*Toolbar toolbar;
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         */
        //holder = new ClientActivity();
        pref = getApplicationContext().getSharedPreferences("HomeServicesPref", 0);
        customerId = pref.getInt("customerId", -1);
        Log.d("HomeService", "customerId: " + customerId );

        holder =  new ViewHolder();
        //holder.showData(Client.Builder.from(getIntent().getExtras()).build()); //habilitar despu'es
    }

    private class ViewHolder {
        private FloatingActionButton buttonSave;
        private EditText textRate;
        private EditText textUser;
        private EditText textPwd;
        private EditText textNames;
        private EditText textLastnames;
        private Spinner textDoctype;
        private EditText textDocnumber;
        private EditText textPhone;
        private EditText textEmail;
        private EditText textAddress;
        private EditText textReference;

        public ViewHolder() {
            textUser = (EditText) findViewById(R.id.text_user);
            textPwd = (EditText) findViewById(R.id.text_pwd);
            textNames = (EditText) findViewById(R.id.text_names);
            textLastnames = (EditText) findViewById(R.id.text_lastnames);
            textDocnumber = (EditText) findViewById(R.id.text_docnumber);
            textPhone = (EditText) findViewById(R.id.text_phone);
            textEmail = (EditText) findViewById(R.id.text_email);
            textAddress = (EditText) findViewById(R.id.text_address);
            textReference = (EditText) findViewById(R.id.text_reference);
            buttonSave = (FloatingActionButton) findViewById(R.id.fab);
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Se grabo un registro", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        public void showData(Client client) {
            textUser.setText(client.getClientLogin());
            textNames.setText(client.getClientNames());
            textLastnames.setText(client.getClientLastnames());
            textDocnumber.setText(client.getClientDocNumber());
            textPhone.setText(client.getClientPhone());
            textEmail.setText(client.getClientEmail());
            textAddress.setText(client.getClientAddress());
            textReference.setText(client.getClientReference());
        }
    }
}