package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingAddress extends AppCompatActivity {
    ImageView imvBack;
    private FragmentAddAddress fragmentAddAddress;
    private FragmentListAddress fragmentListAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_address);

        linkViews();
        addEvents();
        SetFragment();
    }

    private void linkViews() {

        imvBack = findViewById(R.id.imvBack);
        fragmentAddAddress = new FragmentAddAddress();
        fragmentListAddress = new FragmentListAddress();
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void SetFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_address, fragmentAddAddress)
                .replace(R.id.container_listaddress, fragmentListAddress)
                .commit();
    }
}