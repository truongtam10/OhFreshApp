package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.model.Product;
import com.google.android.material.button.MaterialButton;

public class Update extends AppCompatActivity {

    ImageButton btnBack;
    TextView txtCNUnit, txtAppleUnit;
    MaterialButton btnRate, btnRebuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        linkViews();
        customizeText();
        addEvents();
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);
        txtCNUnit = findViewById(R.id.txtCNUnit);
        txtAppleUnit = findViewById(R.id.txtAppleUnit);
        btnRate = findViewById(R.id.btnRate);
        btnRebuy = findViewById(R.id.btnRebuy);
    }

    private void customizeText() {
        String text = "<font color=#00B761><b>0.5</b></font> KG";
        txtCNUnit.setText(Html.fromHtml(text));
        txtAppleUnit.setText(Html.fromHtml(text));
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Update.this, Rating.class);
                startActivity(intent);
            }
        });

        btnRebuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Update.this, ProductDetail.class);
                startActivity(intent);
            }
        });
    }
}