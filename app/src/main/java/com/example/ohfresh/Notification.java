package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notification extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        linkViews();
        configureNavigation();
    }

    private void linkViews() {
        bottomNavigationView = findViewById(R.id.navigation);
    }

    private void configureNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navNotification);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.navHomepage:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navCategory:
                         startActivity(new Intent(getApplicationContext(), Category.class));
                        finish();
                         overridePendingTransition(0,0);
                         return true;
                    case R.id.navNotification:
                        return true;
                    case R.id.navAccount:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}