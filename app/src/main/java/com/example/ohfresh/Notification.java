package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.adapter.NotificationAdapter;
import com.example.model.NotificationItems;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TabHost thNotification;
    ListView lvOffer, lvUpdate;
    NotificationAdapter adapterOffer, adapterUpdate;
    ArrayList<NotificationItems> offers, updates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        linkViews();
        configureNavigation();
        initData();
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

    private void initData() {
        offers = new ArrayList<>();
        offers.add(new NotificationItems(R.drawable.ic_offer, "Ưu đãi", "Oh!Fresh đang nhớ bạn lắm nè", "08:53"));

        updates = new ArrayList<>();
        updates.add(new NotificationItems(R.drawable.ic_update, "Cập nhật đơn hàng", "Đơn hàng 12345678 của bạn đã đư...", "12:34"));
    }

    private void loadData() {
        adapterOffer = new NotificationAdapter(Notification.this, R.layout.notification_layout,offers);
        adapterUpdate = new NotificationAdapter(Notification.this, R.layout.notification_layout,updates);
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