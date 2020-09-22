package com.aranibar.homeservice.viewcontrollers;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class HomeServiceApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
