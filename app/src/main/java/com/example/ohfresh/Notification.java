package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notification extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TabHost thNotification;
    ListView lvOffer, lvUpdate;
    String[] offers, updates;
    ArrayAdapter<String> adapterOffer, adapterUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        linkViews();
        configureNavigation();
        loadData();
        addEvents();
    }

    private void linkViews() {
        bottomNavigationView = findViewById(R.id.navigation);
        thNotification = findViewById(R.id.thNotification);
        lvOffer = findViewById(R.id.lvOffer);
        lvUpdate = findViewById(R.id.lvUpdate);
        thNotification.setup();
        createTab();
    }

    private void loadData() {
        offers = getResources().getStringArray(R.array.offers);
        updates = getResources().getStringArray(R.array.updates);
        adapterOffer = new ArrayAdapter<String>(Notification.this, android.R.layout.simple_list_item_1,offers);
        adapterUpdate = new ArrayAdapter<String>(Notification.this, android.R.layout.simple_list_item_1,updates);
        lvOffer.setAdapter(adapterOffer);
        lvUpdate.setAdapter(adapterUpdate);
    }

    private void addEvents() {
        lvOffer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Notification.this, Offer.class);
                startActivity(intent);
            }
        });

        lvUpdate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Notification.this, Update.class);
                startActivity(intent);
            }
        });
    }

    private void createTab() {
        //Offer
        TabHost.TabSpec tabOffer;
        tabOffer  = thNotification.newTabSpec("tabOffer");
        tabOffer.setContent(R.id.tabOffer);
        tabOffer.setIndicator("Ưu đãi");
        thNotification.addTab(tabOffer);

        //Update
        TabHost.TabSpec tabUpdate;
        tabUpdate = thNotification.newTabSpec("tabUpdate");
        tabUpdate.setContent(R.id.tabUpdate);
        tabUpdate.setIndicator("Cập nhật đơn hàng");
        thNotification.addTab(tabUpdate);
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