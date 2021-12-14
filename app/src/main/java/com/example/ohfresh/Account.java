package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Account extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    LinearLayout lnSupport, lnRank, lnDelivering, lnPolicy, lnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        linkViews();
        configureNavigation();
        addEvents();
    }

    private void linkViews() {
        bottomNavigationView = findViewById(R.id.navigation);
        lnSupport = findViewById(R.id.lnSupport);
        lnRank= findViewById(R.id.lnRank);
        lnDelivering= findViewById(R.id.lnDelivering);
        lnPolicy = findViewById(R.id.lnPolicy);
        lnLogout = findViewById(R.id.lnLogout);
    }

    private void configureNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navAccount);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
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

    private void addEvents() {

        lnDelivering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, Order.class);
                startActivity(intent);
            }
        });


        lnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, MemberRank.class);
                startActivity(intent);
            }
        });


        lnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, HelpCenter.class);
                startActivity(intent);
            }
        });

        lnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, UserPolicy.class);
                startActivity(intent);
            }
        });

        lnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, Login.class);
                startActivity(intent);
            }
        });
    }
}