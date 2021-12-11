package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class Category extends AppCompatActivity {
    GridView gvProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;
    BottomNavigationView bottomNavigationView;
    MaterialButton btnAll, btnVegetable, btnFruit, btnSeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        linkViews();
        initData();
        loadData();
        changeData();
        configureNavigation();
    }

    private void changeData() {
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
                loadData();
            }
        });

        btnVegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products = new ArrayList<Product>();
                products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17000", "KG"));
                products.add(new Product(R.drawable.img_atiso, "Atiso", "35000", "Hoa"));
                products.add(new Product(R.drawable.img_tomato, "Cà chua", "35000", "KG"));
                products.add(new Product(R.drawable.img_bellpepper, "Ớt chuông", "30000", "KG"));
                products.add(new Product(R.drawable.img_caingot, "Cải ngọt", "29000", "KG"));
                products.add(new Product(R.drawable.img_broccoli, "Bông cải", "49000", "KG"));
                products.add(new Product(R.drawable.img_corn, "Ngô", "35000", "KG"));
                products.add(new Product(R.drawable.img_pumpkin, "Bí đỏ", "35000", "KG"));
                loadData();
            }
        });

        btnFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products = new ArrayList<Product>();
                products.add(new Product(R.drawable.img_peach, "Đào", "50000", "KG"));
                products.add(new Product(R.drawable.img_apple, "Táo", "35000", "KG"));
                products.add(new Product(R.drawable.img_banana, "Chuối", "15000", "KG"));
                products.add(new Product(R.drawable.img_cherry, "Cherry", "40000", "KG"));
                products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35000", "KG"));
                products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35000", "KG"));
                products.add(new Product(R.drawable.img_raspberry, "Raspberry", "35000", "KG"));
                loadData();
            }
        });

        btnSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products = new ArrayList<Product>();
                products.add(new Product(R.drawable.img_greenpea, "Đào", "50000", "KG"));
                products.add(new Product(R.drawable.img_mushroom, "Nấm", "35000", "KG"));
                products.add(new Product(R.drawable.img_banana, "Chuối", "15000", "KG"));
                products.add(new Product(R.drawable.img_cherry, "Cherry", "40000", "KG"));
                products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35000", "KG"));
                products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35000", "KG"));
                products.add(new Product(R.drawable.img_raspberry, "Raspberry", "35000", "KG"));
                loadData();
            }
        });
    }

    private void linkViews() {
        gvProduct = findViewById(R.id.gvProduct);
        bottomNavigationView = findViewById(R.id.navigation);

        btnAll = findViewById(R.id.btnAll);
        btnVegetable = findViewById(R.id.btnVegetable);
        btnFruit = findViewById(R.id.btnFruit);
        btnSeed = findViewById(R.id.btnSeed);
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
        products.add(new Product(R.drawable.img_raspberry, "Mâm xôi", "35000", "KG"));
    }

    private void loadData() {
        adapter = new ProductAdapter(Category.this, R.layout.item_layout, products);
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