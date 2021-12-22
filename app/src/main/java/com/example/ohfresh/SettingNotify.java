package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingNotify extends AppCompatActivity {
    TextView txtNotifyChat;
    SwitchCompat switchCompat;
    ImageView imvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_notify);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        txtNotifyChat = findViewById(R.id.txtNotifyChat);
        switchCompat = findViewById(R.id.switch_chat);
        imvBack = findViewById(R.id.imvBack);
    }

    private void addEvents() {
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                txtNotifyChat.setText("Thông báo đã được " + (switchCompat.isChecked()? "bật":"tắt"));
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}