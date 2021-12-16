package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.CartProductAdapter;
import com.example.adapter.VoucherAdapter;
import com.example.model.CartProduct;
import com.example.model.Voucher;

import java.util.ArrayList;

public class SelectVoucher extends AppCompatActivity {

    RecyclerView rcvSelectVoucher;
    ArrayList<Voucher> vouchers;
    VoucherAdapter adapter;

    Button btnSaveVoucher;
    ImageButton btnReturnVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_voucher);

        linkViews();
        configRecyclerView();
        initData();
        addEvent();
    }

    private void linkViews() {

        rcvSelectVoucher = findViewById(R.id.rcvSelectVoucher);

        btnReturnVoucher = findViewById(R.id.btnReturnChangeVoucher);
        btnSaveVoucher = findViewById(R.id.btnSaveVoucher);

    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvSelectVoucher.setLayoutManager(manager);
    }

    private void initData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Voucher("55k", "05/01/2022"));
        vouchers.add(new Voucher("20k", "05/05/2022"));
        vouchers.add(new Voucher("50% tối đa 50k", "05/02/2022"));
        adapter = new VoucherAdapter(getApplicationContext(), vouchers);
        rcvSelectVoucher.setAdapter(adapter);
    }

    private void addEvent() {
        btnReturnVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSaveVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectVoucher.this, Checkout.class);
                startActivity(intent);
            }
        });
    }
}