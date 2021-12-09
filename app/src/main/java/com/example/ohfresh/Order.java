package com.example.ohfresh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

public class Order extends AppCompatActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        linkViews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Đơn hàng");
        return super.onCreateOptionsMenu(menu);
    }

    private void linkViews(){
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();
        createTab();
    }

    private void createTab(){
        //Đang giao
        TabHost.TabSpec tab1;
        tab1  = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Đang giao");
        tabHost.addTab(tab1);

        //Đã giao
        TabHost.TabSpec tab2;
        tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Đã giao");
        tabHost.addTab(tab2);

        //Đã hủy
        TabHost.TabSpec tab3;
        tab3 = tabHost.newTabSpec("tab3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("Đã hủy");
        tabHost.addTab(tab3);
    }
}