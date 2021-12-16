package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class UpdateAddress extends AppCompatActivity {

    ImageButton btnReturnAddress;
    Button btnSaveNewAddress;

    Spinner spinnerCity, spinnerDistrict, spinnerWard;
    ArrayAdapter<String> adapterCity, adapterDistrict, adapterWard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);

        linkViews();
        loadData();
        addEvent();
    }

    private void linkViews() {

        btnReturnAddress = findViewById(R.id.btnReturnAddress);
        btnSaveNewAddress = findViewById(R.id.btnSaveNewAddress);

        spinnerCity = findViewById(R.id.spinnerCity);
        spinnerDistrict = findViewById(R.id.spinnerDistrict);
        spinnerWard = findViewById(R.id.spinnerWard);

    }

    private void loadData() {

        //Spinner City
        adapterCity = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterCity.addAll(getResources().getStringArray(R.array.city_array));

        spinnerCity.setAdapter(adapterCity);

        //Spinner District
        adapterDistrict = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterDistrict.addAll(getResources().getStringArray(R.array.district_array));

        spinnerDistrict.setAdapter(adapterDistrict);

        //Spinner Ward
        adapterWard = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterWard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterWard.addAll(getResources().getStringArray(R.array.district_array));

        spinnerWard.setAdapter(adapterWard);

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