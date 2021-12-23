package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;

public class SearchResult extends AppCompatActivity {

    GridView gvProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;

    ImageView imvBack, imvCart;
    SearchView svSearchInResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        linkViews();
        initData();
        loadData();

        addEvent();
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(SearchResult.this, Category.class);
//                startActivity(intent);
                finish();
            }
        });

        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchResult.this, Cart.class);
                startActivity(intent);
            }
        });

        svSearchInResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });

    }

    private void loadData() {
        adapter = new ProductAdapter(SearchResult.this, R.layout.item_layout, products);
        gvProduct.setAdapter(adapter);
    }

    private void initData() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_nhoden, "Nho Mỹ", "120.000", "KG"));
        products.add(new Product(R.drawable.img_nhotim, "Nho tím", "90.000", "KG"));
        products.add(new Product(R.drawable.img_nhoxanh, "Nho xanh", "100.000", "KG"));
        products.add(new Product(R.drawable.img_nhokhoden, "Nho khô đen", "130.000", "KG"));
    }

    private void linkViews() {
        gvProduct = findViewById(R.id.gvProduct);
        imvBack = findViewById(R.id.imvBack);
        imvCart = findViewById(R.id.imvCart);
        svSearchInResult = findViewById(R.id.svSearchInResult);
    }
}