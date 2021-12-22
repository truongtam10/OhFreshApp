package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SettingPassword extends AppCompatActivity {

    Button btnSave;
    ImageView imvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_password);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t =  Toast.makeText(SettingPassword.this, "Mật khẩu của bạn đã được thay đổi!", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, 20, 0);
                t.show();
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void linkViews() {
        btnSave = findViewById(R.id.btnSave);
        imvBack = findViewById(R.id.imvBack);
    }

}