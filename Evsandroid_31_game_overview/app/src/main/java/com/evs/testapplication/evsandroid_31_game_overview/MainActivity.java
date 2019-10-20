package com.evs.testapplication.evsandroid_31_game_overview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initComponents();
        settingUpSplash();
    }

    private void initComponents() {
        title = findViewById(R.id.splash_title);
        applyingFonts();
    }

    private void applyingFonts() {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"splash_fonts.ttf");
        title.setTypeface(typeface);
    }

    private void settingUpSplash() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent intent = new Intent(MainActivity.this,GameActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });t1.start();
    }
}
