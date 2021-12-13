package com.example.ohfresh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.ProductAdapter;
import com.example.adapter.VoucherAdapter;
import com.example.model.Voucher;

import java.util.ArrayList;


public class selectVoucher extends Fragment {

    RecyclerView rcvSelectVoucher;
    ArrayList<Voucher> vouchers;
    VoucherAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_voucher, container, false);

        rcvSelectVoucher = view.findViewById(R.id.rcvSelectVoucher);
        //adapter = new ProductAdapter(getContext(), R.layout.item_availablevoucher, initData());
        rcvSelectVoucher.setAdapter(adapter);

        return view;
    }

    private ArrayList<Voucher> initData() {
        vouchers = new ArrayList<>();
        vouchers.add( new Voucher(55000, "01/01/2022"));

        return vouchers;

    }
}