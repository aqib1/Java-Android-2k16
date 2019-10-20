package com.evs.testapplication.evsandroid_batch36;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by AQIB JAVED on 1/13/2019.
 */

public class GameActivity  extends Activity{
    private GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingUpWindowWithNoTitle();
        initComponents();
        this.setContentView(gameView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameView.startGame();
    }

    private void initComponents() {
        gameView = new GameView(getApplicationContext());
    }

    private void settingUpWindowWithNoTitle() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
