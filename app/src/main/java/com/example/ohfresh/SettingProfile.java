package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class SettingProfile extends AppCompatActivity {
    Spinner spSex;
    ArrayList<String> sex;
    ArrayAdapter<String> adapter;
    ImageView imvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_profile);

        linkViews();
        loadData();
        addEvents();
    }

    private void linkViews() {
        spSex = findViewById(R.id.spSex);
        imvBack = findViewById(R.id.imvBack);
    }

    private void loadData() {
        sex = new ArrayList<>();
        sex.add("Nam");
        sex.add("Nữ");
        sex.add("Khác");
        adapter = new ArrayAdapter<String>(SettingProfile.this, android.R.layout.simple_list_item_1);
        adapter.addAll(sex);
        spSex.setAdapter(adapter);

    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingProfile.this,Settings.class);
                startActivity(intent);
            }
        });
    }

}