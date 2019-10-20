package com.evs.testapplication.evsandroid_batch36;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;

/**
 * Created by AQIB JAVED on 1/6/2019.
 */

public class RegistrationActivity extends Activity {

    private SlidingDrawer slidingDrawer;
    private LinearLayout signin,registration;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initComponents();
        settingUpListener();
    }

    private void settingUpListener() {
        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                signin.setClickable(false);
                registration.setClickable(true);
            }
        });

        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                signin.setClickable(true);
                registration.setClickable(false);
            }
        });
    }

    private void initComponents() {
        slidingDrawer = findViewById(R.id.sliderregistration);
        signin = findViewById(R.id.signinform);
        registration = findViewById(R.id.registrationform);
    }
}
