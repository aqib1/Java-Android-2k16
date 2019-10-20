package com.evs.testapplication.evsandroid34_lec1_sdkinstallation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by AQIB JAVED on 10/14/2018.
 */

public class SplashActivity extends Activity {

    private TextView splashTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initComponent();
        settingUpSplash();
    }

    private void initComponent() {
        splashTitle = findViewById(R.id.splashTitle);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"splash_fonts.ttf");
        splashTitle.setTypeface(typeface);
    }

    private void settingUpSplash() {
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                Intent intent = new Intent(SplashActivity.this,CameraActivity.class);
                startActivity(intent);
                finish();
            }
        });t1.start();
    }
}
