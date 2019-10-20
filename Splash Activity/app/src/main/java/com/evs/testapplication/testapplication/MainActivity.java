package com.evs.testapplication.testapplication;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }

        );t1.start();
    }
}
