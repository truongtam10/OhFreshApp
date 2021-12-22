package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.model.MyVoucherClick;
import com.example.utils.Constant;

import java.io.Serializable;

public class MyVoucher extends AppCompatActivity implements MyVoucherClick {

    private FragmentManager manager;
    ImageView imvBackToAccount, imvBackToMyVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voucher);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layoutContainer, new FragmentMyvoucher());
        transaction.commit();
        linkViews();
        addEvent();
    }

    private void addEvent() {
//        imvBackToAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
//        imvBackToMyVoucher.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager manager =getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();;
//                Fragment fragment =new FragmentMyvoucher();
//                transaction.replace(R.id.layoutContainer, fragment);
//                transaction.commit();
//            }
//        });
    }

    private void linkViews() {
        imvBackToAccount = findViewById(R.id.imvBackToAccount);
        imvBackToMyVoucher = findViewById(R.id.imvBackToMyVoucher);
    }

    public void click(com.example.model.MyVoucher v){
        FragmentTransaction transaction=manager.beginTransaction();
        InfoFragment infoFragment = new InfoFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.SELECTED_VOUCHER, v);
        infoFragment.setArguments(bundle);

        transaction.replace(R.id.layoutContainer, infoFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}