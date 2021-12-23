package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adapter.OnboardingAdapter;
import com.example.model.OnboardingItems;

import java.util.ArrayList;
import java.util.List;

public class OnboardingScreen extends AppCompatActivity {

    OnboardingAdapter onboardingAdapter;
    ViewPager2 onboardingViewPager;
    LinearLayout onboardingIndicators;
    Button btnGetStarted;
    Button btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);

        linkViews();
        initData();
        loadData();
        setUpIndicators();
        setCurrentIndicator(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });
        addEvents();
    }

    private void linkViews() {

        onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingIndicators = findViewById(R.id.onboardingIndicators);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        btnSkip = findViewById(R.id.btnSkip);
    }

    private void initData() {
        List<OnboardingItems> onboardingItemsList = new ArrayList<>();

        OnboardingItems onboarding1 = new OnboardingItems();
        onboarding1.setTitle("Rau củ tươi sạch");
        onboarding1.setDescription("Chúng tôi biến việc tìm kiếm những loại rau củ quả tươi sạch trở nên đơn giản hơn với bạn. Hãy nhập địa chỉ và để chúng tôi làm những việc còn lại.");
        onboarding1.setImage(R.drawable.onboard1);

        OnboardingItems onboarding2= new OnboardingItems();
        onboarding2.setTitle("Giao hàng nhanh chóng");
        onboarding2.setDescription("Chúng tôi biến việc tìm kiếm những loại rau củ quả tươi sạch trở nên đơn giản hơn với bạn. Hãy nhập địa chỉ và để chúng tôi làm những việc còn lại.");
        onboarding2.setImage(R.drawable.onboard2);

        OnboardingItems onboarding3 = new OnboardingItems();
        onboarding3.setTitle("Thanh toán dễ dàng");
        onboarding3.setDescription("Chúng tôi biến việc tìm kiếm những loại rau củ quả tươi sạch trở nên đơn giản hơn với bạn. Hãy nhập địa chỉ và để chúng tôi làm những việc còn lại.");
        onboarding3.setImage(R.drawable.onboard3);

        onboardingItemsList.add(onboarding1);
        onboardingItemsList.add(onboarding2);
        onboardingItemsList.add(onboarding3);

        onboardingAdapter = new OnboardingAdapter(onboardingItemsList);
    }

    private void loadData() {
        onboardingViewPager.setAdapter(onboardingAdapter);
    }

    private void setUpIndicators() {
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 8, 8, 8);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            onboardingIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int index) {
        int childCount = onboardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) onboardingIndicators.getChildAt(i);
            if(i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
    }

    private void addEvents(){
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingScreen.this, Login.class);
                startActivity(intent);
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingScreen.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

}