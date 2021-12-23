package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class ChangePaymentMethod extends AppCompatActivity {

    RadioButton radCOD, radInternetBanking, radGlobalCard, radMomo, radZaloPay;
    TextView txtMomo, txtZaloPay;
    ImageView btnReturn;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_payment_method);

        linkViews();
        addEvent();
    }

    private void linkViews() {
        radCOD = findViewById(R.id.radCOD);
        radInternetBanking = findViewById(R.id.radInternetBanking);
        radGlobalCard = findViewById(R.id.radGlobalCard);
        radMomo = findViewById(R.id.radMomo);
        radZaloPay = findViewById(R.id.radZaloPay);

        txtMomo = findViewById(R.id.txtMomo);
        txtZaloPay = findViewById(R.id.txtZaloPay);

        btnReturn = findViewById(R.id.btnReturnCheckout);
        btnSave = findViewById(R.id.btnSavePayment);
    }

    private void addEvent() {
        radMomo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radMomo.isChecked()){
                    txtMomo.setText("*Lưu ý: Bạn cần cài đặt ứng dụng Momo để thanh toán");
                } else {
                    txtMomo.setText("");
                }
            }
        });
        radZaloPay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radZaloPay.isChecked()){
                    txtZaloPay.setText("*Lưu ý: Bạn cần cài đặt ứng dụng ZaloPay để thanh toán");
                } else {
                    txtZaloPay.setText("");
                }
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}