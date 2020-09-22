package com.aranibar.homeservice.viewcontrollers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aranibar.homeservice.R;

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
                    context.startActivity(new Intent(context, MainActivity.class));
                }
            });
            imSpecialist.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    context.startActivity(new Intent(context, SpecialistActivity.class));
                }
            });
        }
    }
}