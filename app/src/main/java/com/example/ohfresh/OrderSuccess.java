package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OrderSuccess extends AppCompatActivity {

    ImageButton btnReturnOrder;
    Button btnCheckingOrder, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        linkViews();
        addEvent();
    }

    private void linkViews() {

        btnReturnOrder = findViewById(R.id.btnReturnOrder);
        btnCheckingOrder = findViewById(R.id.btnCheckingOrder);
        btnHome = findViewById(R.id.btnHome);
    }

    private void addEvent() {
        btnReturnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderSuccess.this, HomePage.class);
                startActivity(intent);

            }
        });

        btnCheckingOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderSuccess.this, Update.class);
                startActivity(intent);
            }
        });
    }
}