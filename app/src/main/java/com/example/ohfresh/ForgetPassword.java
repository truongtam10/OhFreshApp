package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {

    Button btnSendOTP;
    EditText edtPhoneInput;
    ImageView imvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        linkViews();
        addEvents();
    }

    private void linkViews(){
        btnSendOTP = findViewById(R.id.btnSendOTP);
        edtPhoneInput = findViewById(R.id.edtPhoneInput);
        imvBack = findViewById(R.id.imvBack);
    }

    private void addEvents(){
        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtPhoneInput.getText().toString().trim().isEmpty()){
                    Toast.makeText(ForgetPassword.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(ForgetPassword.this, OTPVerify.class);
                intent.putExtra("mobile", edtPhoneInput.getText().toString());
                startActivity(intent);
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}