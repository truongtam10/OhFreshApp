package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Account extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    LinearLayout lnSupport, lnRank, lnDelivering, lnPolicy,lnIntroduce,lnMyVoucher, lnRate, lnSetting, lnLogout;
    ImageView imvEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        linkViews();
        configureNavigation();
        addEvents();
    }

    private void linkViews() {
        bottomNavigationView = findViewById(R.id.navigation);
        lnSupport = findViewById(R.id.lnSupport);
        lnRank= findViewById(R.id.lnRank);
        lnDelivering= findViewById(R.id.lnDelivering);
        lnPolicy = findViewById(R.id.lnPolicy);
        lnIntroduce= findViewById(R.id.lnIntroduce);
        lnMyVoucher = findViewById(R.id.lnMyVoucher);
        lnRate = findViewById(R.id.lnRate);
        lnSetting = findViewById(R.id.lnSetting);
        lnLogout = findViewById(R.id.lnLogout);

        imvEdit = findViewById(R.id.imvEdit);

    }

    private void configureNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navAccount);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.navHomepage:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navCategory:
                        startActivity(new Intent(getApplicationContext(), Category.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navNotification:
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navAccount:
                        return true;
                }
                return false;
            }
        });

    }

    private void addEvents() {
        imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, SettingProfile.class);
                startActivity(intent);
            }
        });

        lnDelivering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, Order.class);
                startActivity(intent);
            }
        });


        lnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, MemberRank.class);
                startActivity(intent);
            }
        });


        lnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, HelpCenter.class);
                startActivity(intent);
            }
        });

        lnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, UserPolicy.class);
                startActivity(intent);
            }
        });
        lnIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this,IntroduceFriend.class);
                startActivity(intent);
            }
        });
        lnMyVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this,MyVoucher.class);
                startActivity(intent);
            }
        });

        lnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account.this, Settings.class);
                startActivity(intent);
            }
        });

        lnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(Account.this, Login.class);
                startActivity(intent);
            }
        });

    }
    public Account() {
        super();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}