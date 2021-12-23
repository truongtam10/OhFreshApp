package com.example.ohfresh;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.CartProductAdapter;
import com.example.model.CartProduct;
import com.example.model.Product;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    ListView lvProduct;
    ArrayList<CartProduct> products;
    CartProductAdapter adapter;

    ImageView btnReturnOutCart;
    Button btnCheckoutItem;
    TextView txtSelectVoucherCart, txtNumberProduct;

    ImageButton btnAdd, btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        linkViews();
        initData();
        addEvent();

    }


    private void linkViews() {

        lvProduct = findViewById(R.id.lvProduct);
        btnCheckoutItem = findViewById(R.id.btnCheckOutItem);
        btnReturnOutCart = findViewById(R.id.btnReturnOutCart);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        txtSelectVoucherCart = findViewById(R.id.txtSelectVoucherCart);
        txtNumberProduct = findViewById(R.id.txtNumberProduct);
    }

    /*private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lvProduct.setLayoutManager(manager);
    }*/

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
        adapter = new CartProductAdapter(Cart.this,R.layout.cart_itemlayout,products);
        lvProduct.setAdapter(adapter);
    }

    private void addEvent() {
        btnReturnOutCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCheckoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, Checkout.class);
                startActivity(intent);
            }
        });

        txtSelectVoucherCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, SelectVoucher.class);
                startActivity(intent);
            }
        });

        /*btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt(txtNumberProduct.getText().toString());
                if(sl>0)
                {
                    sl = sl -1;
                    txtNumberProduct.setText(String.valueOf(sl));;
                }
            }
        });*/

        /*btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt(txtNumberProduct.getText().toString());
                if(sl>0 || sl==0)
                {
                    sl = sl + 1;
                    txtNumberProduct.setText(String.valueOf(sl));
                }
            }
        });*/

    }
}