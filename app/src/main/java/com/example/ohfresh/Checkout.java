package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.CartProductAdapter;
import com.example.adapter.ItemCheckoutAdapter;
import com.example.adapter.PaymentAdapter;
import com.example.model.CartProduct;
import com.example.model.PaymentMethod;
import com.example.model.Product;

import java.util.ArrayList;


public class Checkout extends AppCompatActivity {

    RecyclerView rcvPaymentMethod;
    RecyclerView rcvCheckoutItem;
    ArrayList<PaymentMethod> paymentMethods;
    PaymentAdapter paymentAdapter;
    ArrayList<CartProduct> products;
    ItemCheckoutAdapter itemCheckoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        linkViews();
        configRecyclerViewPaymentMethod();
        configRecyclerViewItemCheckout();
        initDataPaymentMethod();
        initDataItemCheckout();
    }

    private void configRecyclerViewItemCheckout() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvCheckoutItem.setLayoutManager(manager);
    }

    private void configRecyclerViewPaymentMethod() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvPaymentMethod.setLayoutManager(manager);
    }

    private void linkViews() {

        rcvPaymentMethod = findViewById(R.id.rcvCheckoutPaymentMethods);
        rcvCheckoutItem = findViewById(R.id.rcvCheckoutItem);
    }

    private void initDataPaymentMethod() {
        paymentMethods = new ArrayList<>();
        paymentMethods.add(new PaymentMethod("Tiền mặt",R.drawable.ic_cash,"Thanh toán khi nhận hàng"));
        paymentMethods.add(new PaymentMethod("Ví Momo",R.drawable.ic_momo,"Liên kết tài khoản Momo"));
        paymentMethods.add(new PaymentMethod("Thẻ", R.drawable.ic_card, "Thêm thẻ tín dụng/ghi nợ"));
        paymentMethods.add(new PaymentMethod("Ví ZaloPay",R.drawable.ic_zalo,"Liên kết tài khoản ZaloPay"));

        paymentAdapter = new PaymentAdapter(getApplicationContext(), paymentMethods);
        rcvPaymentMethod.setAdapter(paymentAdapter);
    }

    private void initDataItemCheckout() {
        products = new ArrayList<>();
        products.add(new CartProduct(R.drawable.img_caingot, "Cải ngọt", 17000, 1, 1));
        products.add(new CartProduct(R.drawable.img_strawberry, "Dâu tây", 102000, 0.5, 1));
        products.add(new CartProduct(R.drawable.img_banana, "Chuối", 27000, 1, 2));

        itemCheckoutAdapter = new ItemCheckoutAdapter(getApplicationContext(), products);
        rcvCheckoutItem.setAdapter(itemCheckoutAdapter);
    }
}