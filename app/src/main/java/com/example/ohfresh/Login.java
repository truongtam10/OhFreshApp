package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView txtMissPass, txtCreateAccount;
    Button btnLogin;
    EditText edtPhoneInput, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        linkViews();
        addEvents();
    }

    private void linkViews(){
        txtMissPass = findViewById(R.id.txtMissPass);
        txtCreateAccount= findViewById(R.id.txtCreateAccount);
        btnLogin = findViewById(R.id.btnLogin);
        edtPhoneInput = findViewById(R.id.edtPhoneInput);
        edtPassword = findViewById(R.id.edtPassword);


    }

    private void addEvents(){
        txtMissPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtPhoneInput.getText().toString().trim().isEmpty() || edtPassword.getText().toString().trim().isEmpty()){
                    Toast.makeText(Login.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(Login.this, HomePage.class);
                startActivity(intent);


            }
        });

    }

}