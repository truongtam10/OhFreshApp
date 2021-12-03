package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.CartProductAdapter;
import com.example.model.CartProduct;
import com.example.model.Product;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    RecyclerView rcvProduct;
    ArrayList<CartProduct> products;
    CartProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        linkViews();
        configRecyclerView();
        initData();
    }

    private void linkViews() {
        rcvProduct = findViewById(R.id.rcvProduct);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvProduct.setLayoutManager(manager);
    }

    private void initData() {
        products = new ArrayList<>();
        products.add(new CartProduct(R.drawable.img_caingot, "Cải ngọt", 17000, 1, 1));
        products.add(new CartProduct(R.drawable.img_strawberry, "Dâu tây", 102000, 0.5, 1));
        products.add(new CartProduct(R.drawable.img_banana, "Chuối", 27000, 1, 2));
        products.add(new CartProduct(R.drawable.img_raspberry, "Mâm xôi đỏ", 220000, 0.5, 1));
        products.add(new CartProduct(R.drawable.img_tomato, "Cà chua", 30000, 1, 2));
        products.add(new CartProduct(R.drawable.img_cherry, "Cherry", 179000, 0.5, 1));
        products.add(new CartProduct(R.drawable.img_peach, "Đào", 67000, 1, 4));
        products.add(new CartProduct(R.drawable.img_blueberry, "Việt quất", 325000, 5, 1));
        adapter = new CartProductAdapter(getApplicationContext(), products);
        rcvProduct.setAdapter(adapter);
    }
}