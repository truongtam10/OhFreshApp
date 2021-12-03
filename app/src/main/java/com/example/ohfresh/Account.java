package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        linkViews();
        configureNavigation();
    }

    private void linkViews() {
        bottomNavigationView = findViewById(R.id.navigation);
    }

    private void configureNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navAccount);

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
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navAccount:
                        return true;
                }
                return false;
            }
        });

    }
}