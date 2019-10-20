package com.evs.testapplication.gamelecturetesting;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by AQIB JAVED on 10/20/2018.
 */

public class GameActivity extends Activity {
    private GameSerface serface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        serface = new GameSerface(this);
        setContentView(serface);
    }

    @Override
    protected void onPause() {
        super.onPause();
        serface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        serface.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        serface.startThread();
    }

    @Override
    protected void onStop() {
        super.onStop();
        serface.stopThread();
    }
}
