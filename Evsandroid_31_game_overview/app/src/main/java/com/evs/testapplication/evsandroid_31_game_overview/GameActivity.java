package com.evs.testapplication.evsandroid_31_game_overview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by AQIB JAVED on 10/20/2018.
 */

public class GameActivity extends Activity {
    private GameSurface gameSurface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameSurface = new GameSurface(getApplicationContext());
        setContentView(gameSurface);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameSurface.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gameSurface.onStop();
    }
}
