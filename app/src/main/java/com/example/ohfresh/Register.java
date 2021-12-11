package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button btnRegister;
    EditText edtUserName, edtEmail, edtPhoneInput, edtPassword, edtRePassword;
    CheckBox chkProvision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        linkViews();
        addEvents();
    }

    private void linkViews(){
        btnRegister = findViewById(R.id.btnRegister);
        edtUserName = findViewById(R.id.edtUserName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhoneInput = findViewById(R.id.edtPhoneInput);
        edtPassword = findViewById(R.id.edtPassword);
        edtRePassword = findViewById(R.id.edtRePassword);
        chkProvision = findViewById(R.id.chkProvision);
    }

    private void addEvents(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUserName.getText().toString().trim().isEmpty()
                    && edtEmail.getText().toString().trim().isEmpty()
                    && edtPhoneInput.getText().toString().trim().isEmpty()
                    && edtPassword.getText().toString().trim().isEmpty()
                    && edtRePassword.getText().toString().trim().isEmpty()){

                    Toast.makeText(Register.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;

                }
            }
        });
    }
}