package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

public class SettingCard extends AppCompatActivity {
    ImageView imvBack;
    LinearLayout lnAdd;
    MaterialButton btnAddCard;
    private FragmentListCard fragmentListCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_card);

        linkViews();
        SetFragment();
        addEvents();


    }

    private void linkViews() {
        imvBack = findViewById(R.id.imvBack);
        lnAdd = findViewById(R.id.lnAdd);
        fragmentListCard = new FragmentListCard();
        btnAddCard = findViewById(R.id.btnAddCard);
    }

    private void SetFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_listcard, fragmentListCard)
                .commit();
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment mFragment = null;
                mFragment = new FragmentAddCard();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_addcard, mFragment).commit();
            }
        });
    }
}