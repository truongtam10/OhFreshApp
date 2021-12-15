package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Settings extends AppCompatActivity {
    LinearLayout lnProfile,lnAddress,lnCard,lnSettingChat, lnNotify, lnCancelAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        lnProfile = findViewById(R.id.lnProfile);
        lnAddress = findViewById(R.id.lnAddress);
        lnCard = findViewById(R.id.lnCard);
        lnSettingChat = findViewById(R.id.lnSettingChat);
        lnNotify = findViewById(R.id.lnNotify);
        lnCancelAcc = findViewById(R.id.lnCancelAcc);
    }

    public void openDialog(View view){
        Dialog dialog = new Dialog(Settings.this);
        dialog.setContentView(R.layout.custom_dialog);
        ImageButton imbOk = dialog.findViewById(R.id.imbOk);
        imbOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Settings.this,Login.class);
                startActivity(intent);
            }
        });

        ImageButton imbNo = dialog.findViewById(R.id.imbNo);
        imbNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private void addEvents() {
        lnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,SettingProfile.class);
                startActivity(intent);
            }
        });

        lnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,SettingAddress.class);
                startActivity(intent);
            }
        });

        lnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,SettingCard.class);
                startActivity(intent);
            }
        });

        lnSettingChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,SettingChat.class);
                startActivity(intent);
            }
        });

        lnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,SettingNotify.class);
                startActivity(intent);
            }
        });
    }
}