package com.example.ohfresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (!isFinishing()){
                startActivity(new Intent(getApplicationContext(), OnboardingScreen.class));
                finish();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 4000); //Time to display
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}