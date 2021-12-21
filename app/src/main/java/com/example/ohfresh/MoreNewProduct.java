package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MoreNewProduct extends AppCompatActivity {
    GridView gvProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;
    BottomNavigationView bottomNavigationView;
    ImageButton imbBack, imbCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_new_product);

        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        gvProduct = findViewById(R.id.gvMoreProduct);
        bottomNavigationView = findViewById(R.id.navigation);
        imbBack = findViewById(R.id.imbBack);
        imbCart = findViewById(R.id.imbCart);
    }

    private void initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_apple, "Táo", "35000", "KG"));
        products.add(new Product(R.drawable.img_banana, "Chuối", "15000", "KG"));
        products.add(new Product(R.drawable.img_cherry, "Cherry", "40000", "KG"));
        products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17000", "KG"));
        products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35000", "KG"));
        products.add(new Product(R.drawable.img_atiso, "Atiso", "35000", "Hoa"));
        products.add(new Product(R.drawable.img_tomato, "Cà chua", "35000", "KG"));
        products.add(new Product(R.drawable.img_raspberry, "Mâm xôi", "35000", "KG"));
    }

    private void loadData() {
        adapter = new ProductAdapter(MoreNewProduct.this, R.layout.item_layout, products);
        gvProduct.setAdapter(adapter);
    }

    private void addEvents() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imbCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreNewProduct.this,Cart.class);
                startActivity(intent);
            }
        });
    }
}