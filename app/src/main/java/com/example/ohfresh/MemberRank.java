package com.example.ohfresh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

public class MemberRank extends AppCompatActivity {

    ImageView imvBack;

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_rank);

        linkViews();
        addEvents();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Đơn hàng");
        return super.onCreateOptionsMenu(menu);
    }

    private void linkViews(){
        imvBack = findViewById(R.id.imvBack);
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();
        createTab();
    }

    private void addEvents(){
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberRank.this, Account.class);
                startActivity(intent);
            }
        });
    }

    private void createTab(){
        //Member
        TabHost.TabSpec tab1;
        tab1  = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Thành viên");
        tabHost.addTab(tab1);

        //Silver
        TabHost.TabSpec tab2;
        tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Bạc");
        tabHost.addTab(tab2);

        //Gold
        TabHost.TabSpec tab3;
        tab3 = tabHost.newTabSpec("tab3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("Vàng");
        tabHost.addTab(tab3);

    }
}