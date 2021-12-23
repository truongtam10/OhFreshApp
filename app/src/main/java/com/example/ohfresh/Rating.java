package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Rating extends AppCompatActivity {

    ImageView imvBack;
    Button btnSendRating;
    EditText edtRatingContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        linkViews();
        addEvents();
    }

    private void linkViews(){

        imvBack = findViewById(R.id.imvBack);
        btnSendRating = findViewById(R.id.btnSendRating);
        edtRatingContent = findViewById(R.id.edtRatingContent);
    }

    private void addEvents(){
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSendRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtRatingContent.getText().toString().trim().isEmpty()){
                    Toast.makeText(Rating.this, "Bạn chưa nhập đánh giá!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Rating.this, "Đánh giá thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Rating.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}