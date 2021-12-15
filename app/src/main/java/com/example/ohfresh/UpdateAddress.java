package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class UpdateAddress extends AppCompatActivity {

    ImageButton btnReturnAddress;
    Button btnSaveNewAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);

        linkViews();
        addEvent();
    }

    private void linkViews() {

        btnReturnAddress = findViewById(R.id.btnReturnAddress);
        btnSaveNewAddress = findViewById(R.id.btnSaveNewAddress);
    }

    private void addEvent() {
        btnReturnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateAddress.this, Checkout.class);
                startActivity(intent);
            }
        });

        btnSaveNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateAddress.this, Checkout.class);
                startActivity(intent);
            }
        });
    }
}