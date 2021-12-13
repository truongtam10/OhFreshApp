package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MoreNewProduct extends AppCompatActivity {
    GridView gvProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_new_product);

        linkViews();
        initData();
        loadData();
        configureNavigation();
    }

    private void linkViews() {
        gvProduct = findViewById(R.id.gvProduct);
        bottomNavigationView = findViewById(R.id.navigation);
    }

    private void initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_apple, "Táo", "35000", "KG"));
        products.add(new Product(R.drawable.img_banana, "Chuối", "15000", "KG"));
        products.add(new Product(R.drawable.img_cherry, "Cherry", "40000", "KG"));
        products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17000", "KG"));
        products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35000", "KG"));
        products.add(new Product(R.drawable.img_atiso, "Atiso", "35000", "Hoa"));
        products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35000", "KG"));
        products.add(new Product(R.drawable.img_tomato, "Cà chua", "35000", "KG"));
    }

    private void loadData() {
        adapter = new ProductAdapter(MoreNewProduct.this, R.layout.item_layout, products);
        gvProduct.setAdapter(adapter);
    }

    private void configureNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navCategory);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navHomepage:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navCategory:
                        return true;
                    case R.id.navNotification:
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navAccount:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }
}