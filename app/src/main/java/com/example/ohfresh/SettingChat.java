package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingChat extends AppCompatActivity {
    ImageView imvBack;
    private FragmentAddMessage fragmentAddMessage;
    private FragmentListMessage fragmentListMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_chat);

        linkViews();
        addEvents();
        SetFragment();
    }

    private void linkViews() {
        imvBack = findViewById(R.id.imvBack);
        fragmentAddMessage = new FragmentAddMessage();
        fragmentListMessage = new FragmentListMessage();
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
                .replace(R.id.container_addmess, fragmentAddMessage)
                .replace(R.id.container_listmess, fragmentListMessage)
                .commit();
    }
}