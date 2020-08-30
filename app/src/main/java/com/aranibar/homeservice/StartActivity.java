package com.aranibar.homeservice;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    ViewHolder holder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        holder = new ViewHolder();



    }

    private class ViewHolder{
        private Button imClient;
        private Button imSpecialist;

        public ViewHolder() {
            imClient = (Button) findViewById(R.id.button_im_client);
            imSpecialist = (Button) findViewById(R.id.button_im_specialist);
            imClient.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    context.startActivity(new Intent(context, LoginActivity.class));
                }
            });
            imSpecialist.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    context.startActivity(new Intent(context, LoginActivity.class));
                }
            });
        }
    }
}