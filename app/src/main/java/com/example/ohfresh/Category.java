package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Category extends AppCompatActivity {
    GridView gvProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;
    BottomNavigationView bottomNavigationView;
    MaterialButton btnAll, btnVegetable, btnFruit, btnSeed;
    SearchView svSearch;
    ImageView imvCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        linkViews();
        initData();
        loadData();
        changeData();
        addEvent();
        configureNavigation();

    }

    private void addEvent() {
        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category.this, Cart.class);
                startActivity(intent);
            }
        });

        gvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                startActivity(intent);
            }
        });

        svSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.svSearch) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Category, new SearchFragment()).commit();
                }
            }
        });
    }

    private void changeData() {
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAll.setBackgroundColor(Color.parseColor("#00B761"));
                btnAll.setTextColor(Color.parseColor("#ffffff"));

                btnVegetable.setBackgroundColor(Color.parseColor("#ffffff"));
                btnVegetable.setTextColor(Color.parseColor("#00B761"));
                btnSeed.setBackgroundColor(Color.parseColor("#ffffff"));
                btnSeed.setTextColor(Color.parseColor("#00B761"));
                btnFruit.setBackgroundColor(Color.parseColor("#ffffff"));
                btnFruit.setTextColor(Color.parseColor("#00B761"));

                initData();
                loadData();
            }
        });

        btnVegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnVegetable.setBackgroundColor(Color.parseColor("#00B761"));
                btnVegetable.setTextColor(Color.parseColor("#ffffff"));

                btnAll.setBackgroundColor(Color.parseColor("#ffffff"));
                btnAll.setTextColor(Color.parseColor("#00B761"));
                btnSeed.setBackgroundColor(Color.parseColor("#ffffff"));
                btnSeed.setTextColor(Color.parseColor("#00B761"));
                btnFruit.setBackgroundColor(Color.parseColor("#ffffff"));
                btnFruit.setTextColor(Color.parseColor("#00B761"));

                products = new ArrayList<Product>();
                products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17.000", "KG"));
                products.add(new Product(R.drawable.img_atiso, "Atiso", "35.000", "Hoa"));
                products.add(new Product(R.drawable.img_tomato, "Cà chua", "35.000", "KG"));
                products.add(new Product(R.drawable.img_bellpepper, "Ớt chuông", "30.000", "KG"));
                products.add(new Product(R.drawable.img_caingot, "Cải ngọt", "29.000", "KG"));
                products.add(new Product(R.drawable.img_bongcai, "Bông cải", "49.000", "KG"));
                products.add(new Product(R.drawable.img_corn, "Ngô", "35.000", "KG"));
                products.add(new Product(R.drawable.img_pumpkin, "Bí đỏ", "35.000", "KG"));
                loadData();
            }
        });

        btnFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFruit.setBackgroundColor(Color.parseColor("#00B761"));
                btnFruit.setTextColor(Color.parseColor("#ffffff"));

                btnAll.setBackgroundColor(Color.parseColor("#ffffff"));
                btnAll.setTextColor(Color.parseColor("#00B761"));
                btnSeed.setBackgroundColor(Color.parseColor("#ffffff"));
                btnSeed.setTextColor(Color.parseColor("#00B761"));
                btnVegetable.setBackgroundColor(Color.parseColor("#ffffff"));
                btnVegetable.setTextColor(Color.parseColor("#00B761"));

                products = new ArrayList<Product>();
                products.add(new Product(R.drawable.img_peach, "Đào", "50.000", "KG"));
                products.add(new Product(R.drawable.img_apple, "Táo", "35.000", "KG"));
                products.add(new Product(R.drawable.img_banana, "Chuối", "15.000", "KG"));
                products.add(new Product(R.drawable.img_cherry, "Cherry", "40.000", "KG"));
                products.add(new Product(R.drawable.img_nhoxanh, "Nho xanh", "35.000", "KG"));
                products.add(new Product(R.drawable.img_nhotim, "Nho tím", "35.000", "KG"));
                products.add(new Product(R.drawable.img_nhoden, "Nho Mỹ", "35.000", "KG"));
                products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35.000", "KG"));
                products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35.000", "KG"));
                products.add(new Product(R.drawable.img_raspberry, "Raspberry", "35.000", "KG"));
                loadData();
            }
        });

        btnSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSeed.setBackgroundColor(Color.parseColor("#00B761"));
                btnSeed.setTextColor(Color.parseColor("#ffffff"));

                btnAll.setBackgroundColor(Color.parseColor("#ffffff"));
                btnAll.setTextColor(Color.parseColor("#00B761"));
                btnVegetable.setBackgroundColor(Color.parseColor("#ffffff"));
                btnVegetable.setTextColor(Color.parseColor("#00B761"));
                btnFruit.setBackgroundColor(Color.parseColor("#ffffff"));
                btnFruit.setTextColor(Color.parseColor("#00B761"));

                products = new ArrayList<Product>();
                products.add(new Product(R.drawable.img_cashew, "Hạt điều", "50.000", "KG"));
                products.add(new Product(R.drawable.img_chia, "Hạt Chia", "35.000", "KG"));
                products.add(new Product(R.drawable.img_flax, "Hạt dưa", "15.000", "KG"));
                products.add(new Product(R.drawable.img_macca, "Hạt Macca", "40.000", "KG"));
                products.add(new Product(R.drawable.img_occho, "Hạt óc chó", "35.000", "KG"));
                products.add(new Product(R.drawable.img_hemp, "Gai dầu", "35.000", "KG"));
                products.add(new Product(R.drawable.img_oats, "Yến mạch", "35.000", "KG"));
                products.add(new Product(R.drawable.img_nhokhoden, "Nho khô", "35.000", "KG"));
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

        svSearch = findViewById(R.id.svSearch);
        imvCart = findViewById(R.id.imvCart);
    }

    private void initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_apple, "Táo", "35000", "KG"));
        products.add(new Product(R.drawable.img_banana, "Chuối", "15000", "KG"));
        products.add(new Product(R.drawable.img_cherry, "Cherry", "40000", "KG"));
        products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17000", "KG"));
        products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35000", "KG"));
        products.add(new Product(R.drawable.img_atiso, "Atiso", "35000", "Hoa"));
        products.add(new Product(R.drawable.img_macca, "Hạt Macca", "40.000", "KG"));
        products.add(new Product(R.drawable.img_occho, "Hạt óc chó", "35.000", "KG"));
        products.add(new Product(R.drawable.img_hemp, "Gai dầu", "35.000", "KG"));
        products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35000", "KG"));
        products.add(new Product(R.drawable.img_tomato, "Cà chua", "35000", "KG"));
        products.add(new Product(R.drawable.img_raspberry, "Mâm xôi", "35000", "KG"));
        products.add(new Product(R.drawable.img_bongcai, "Bông cải", "49.000", "KG"));
        products.add(new Product(R.drawable.img_corn, "Ngô", "35.000", "KG"));
        products.add(new Product(R.drawable.img_pumpkin, "Bí đỏ", "35.000", "KG"));
    }

    private void loadData() {
        adapter = new ProductAdapter(Category.this, R.layout.item_layout, products);
        gvProduct.setAdapter(adapter);
    }

    private void configureNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navCategory);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
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