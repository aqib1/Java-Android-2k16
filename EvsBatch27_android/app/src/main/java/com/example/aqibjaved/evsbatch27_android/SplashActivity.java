package com.example.aqibjaved.evsbatch27_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by AQIB JAVED on 2/25/2018.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        settingUpMainActivity();
        
    }

    private void settingUpMainActivity() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
//                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    Intent intent = new Intent(SplashActivity.this,SignUp.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });t1.start();
    }
}
