package com.evs.testapplication.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by AQIB JAVED on 8/5/2018.
 */

public class SplashActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){}
                    Intent intent = new Intent("com.example.evs.MAINACTIVITY");
                    startActivity(intent);
                    finish();
            }
        });t1.start();
    }
}
