package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.DetailAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ProductDetail extends AppCompatActivity {
    ViewPager2 vpCTSP;
    ImageButton imbTru, imbCong;
    TextView txtSL;
    ArrayList<Integer> products;
    DetailAdapter adapter;
    TextView[] dots;
    LinearLayout dotsLayout;
    MaterialButton btnThem;
    ImageButton imbBack, imbCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        linkView();
        initData();
        addEvent();
    }

    private void linkView() {
        dotsLayout = findViewById(R.id.dotsContainer);
        vpCTSP = findViewById(R.id.vpCTSP);
        imbCong = findViewById(R.id.imbCong);
        imbTru = findViewById(R.id.imbTru);
        txtSL  =findViewById(R.id.txtSL);
        btnThem = findViewById(R.id.btnThem);
        imbBack = findViewById(R.id.imbBack);
        imbCart = findViewById(R.id.imbCart);
    }

    private void initData() {
        products = new ArrayList<>();
        products.add(R.drawable.img_apple);
        products.add(R.drawable.img_apple_d1);
        products.add(R.drawable.img_apple_d2);
        products.add(R.drawable.img_apple_d3);
        products.add(R.drawable.img_apple_d4);
        adapter= new DetailAdapter(getApplicationContext(), products);
        vpCTSP.setAdapter(adapter);
        dots = new TextView[products.size()];
        dotsIndicator();
        vpCTSP.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectedIndicator(position);
                super.onPageSelected(position);
            }
        });
    }

    private void addEvent() {
        imbTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt(txtSL.getText().toString());
                if(sl>0)
                {
                    sl = sl -1;
                    txtSL.setText(String.valueOf(sl));;
                }
            }
        });

        imbCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl = Integer.parseInt(txtSL.getText().toString());
                if(sl>0 || sl==0)
                {
                    sl = sl + 1;
                    txtSL.setText(String.valueOf(sl));
                }
            }
        });

        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Đã thêm hàng vào giỏ", Toast.LENGTH_SHORT).show();
            }
        });

        imbCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cart.class);
                startActivity(intent);
            }
        });
    }

    private void selectedIndicator(int position) {
        for(int i=0; i<dots.length; i++)
        {
            if (i==position) {
                dots[i].setTextColor(getResources().getColor(R.color.mainGreen));
            }
            else
            {
                dots[i].setTextColor(getResources().getColor(R.color.mainGray));
            }
        }
    }

    private void dotsIndicator() {
        for(int i=0; i<dots.length; i++)
        {
            dots [i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            dotsLayout.addView(dots[i]);
        }
    }
}