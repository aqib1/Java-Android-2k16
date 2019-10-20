package com.evs.testapplication.evsandroid_batch36;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * Created by AQIB JAVED on 12/8/2018.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        settingUpSplash();
    }

    private void settingUpSplash() {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        SharedPrefHolderSingleton.getInstance()
                                .init(getApplicationContext());
                        try {
                            TimeUnit.SECONDS.sleep(5);
                            Intent intent = new Intent(SplashActivity.this,SettingActivity2.class);
//                            intent.putExtra()
                            startActivity(intent);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        t1.start();
    }
}
