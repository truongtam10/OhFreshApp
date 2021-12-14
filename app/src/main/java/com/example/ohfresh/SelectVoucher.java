package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.CartProductAdapter;
import com.example.adapter.VoucherAdapter;
import com.example.model.CartProduct;
import com.example.model.Voucher;

import java.util.ArrayList;

public class SelectVoucher extends AppCompatActivity {

    RecyclerView rcvSelectVoucher;
    ArrayList<Voucher> vouchers;
    VoucherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_voucher);

        linkViews();
        configRecyclerView();
        initData();
    }

    private void linkViews() {
        rcvSelectVoucher = findViewById(R.id.rcvSelectVoucher);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvSelectVoucher.setLayoutManager(manager);
    }

    private void initData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Voucher(55000, "05/01/2022"));
        vouchers.add(new Voucher(155000, "05/05/2022"));
        vouchers.add(new Voucher(25000, "05/02/2022"));
        adapter = new VoucherAdapter(getApplicationContext(), vouchers);
        rcvSelectVoucher.setAdapter(adapter);
    }
}