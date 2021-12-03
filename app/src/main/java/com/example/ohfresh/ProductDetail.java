package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adapter.DetailAdapter;

import java.util.ArrayList;

public class ProductDetail extends AppCompatActivity {
    ViewPager2 vpCTSP;
    ImageButton imbTru, imbCong;
    TextView txtSL;
    ArrayList<Integer> products;
    DetailAdapter adapter;
    TextView[] dots;
    LinearLayout dotsLayout;

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
    }

    private void initData() {
        products = new ArrayList<>();
        products.add(R.drawable.cabbage1);
        products.add(R.drawable.cabbage2);
        products.add(R.drawable.cabbage3);
        products.add(R.drawable.cabbage4);
        products.add(R.drawable.cabbage5);
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