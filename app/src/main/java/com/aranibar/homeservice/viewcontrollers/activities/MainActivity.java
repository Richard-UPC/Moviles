package com.aranibar.homeservice.viewcontrollers.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aranibar.homeservice.R;
import com.aranibar.homeservice.viewcontrollers.fragments.DealsFragment;
import com.aranibar.homeservice.viewcontrollers.fragments.ProfileFragment;
import com.aranibar.homeservice.viewcontrollers.fragments.SearchFragment;
import com.aranibar.homeservice.viewcontrollers.fragments.SpecialistFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateTo(item);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        int itemId =  navigation.getSelectedItemId() == 0 ? R.id.navigation_search : navigation.getSelectedItemId();
        navigateTo(navigation.getMenu().findItem(itemId));
    }

    private Fragment getFragmentFor (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_profile: return new ProfileFragment();
            case R.id.navigation_search: return new SpecialistFragment();
            case R.id.navigation_deals: return new DealsFragment();
            default: return new SpecialistFragment();
        }
    }

    private boolean navigateTo (MenuItem item) {
        item.setChecked(true);

        Fragment fragment = getFragmentFor(item);
        fragment.setArguments(getIntent().getExtras());
         return getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit() > 0;
    }


}