package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Search extends AppCompatActivity {

    ImageView imvBack;
    LinearLayout linearSearch, linearProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        linkView();
        addEvents();
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Category.class);
                startActivity(intent);
            }
        });

        linearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, SearchResult.class);
                startActivity(intent);
            }
        });

        linearProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, ProductDetail.class);
                startActivity(intent);
            }
        });
    }

    private void linkView() {
        imvBack = findViewById(R.id.imvBack);
        linearSearch = findViewById(R.id.linearSearch);
        linearProduct = findViewById(R.id.linearProduct);
    }
}