package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

public class UserPolicy extends AppCompatActivity {

    ImageButton btnBack;
    TabHost thPolicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_policy);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);
        thPolicy = findViewById(R.id.thPolicy);
        thPolicy.setup();
        createTab();
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void createTab() {
        //Term of Use
        TabHost.TabSpec tabTermofUse;
        tabTermofUse  = thPolicy.newTabSpec("tabTermofUse");
        tabTermofUse.setContent(R.id.tabTermofUse);
        tabTermofUse.setIndicator("Điều khoản sử dụng");
        thPolicy.addTab(tabTermofUse);

        //Privacy Policy
        TabHost.TabSpec tabPrivacyPolicy;
        tabPrivacyPolicy = thPolicy.newTabSpec("tabPrivacyPolicy");
        tabPrivacyPolicy.setContent(R.id.tabPrivacyPolicy);
        tabPrivacyPolicy.setIndicator("Chính sách bảo mật");
        thPolicy.addTab(tabPrivacyPolicy);

    }
}