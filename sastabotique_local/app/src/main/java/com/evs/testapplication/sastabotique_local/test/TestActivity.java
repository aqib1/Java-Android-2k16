package com.evs.testapplication.sastabotique_local.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;

import com.evs.testapplication.sastabotique_local.R;

/**
 * Created by AQIB JAVED on 9/1/2018.
 */

public class TestActivity extends Activity {
    private LinearLayout background,content;
    private SlidingDrawer sd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        sd.setOnDrawerOpenListener(()->{
            background.setClickable(false);
            content.setClickable(true);
        });
        sd.setOnDrawerCloseListener(()->{
            content.setClickable(false);
            background.setClickable(true);
        });
    }

    private void initComponents() {

        sd = findViewById(R.id.sd);
        background = findViewById(R.id.background);
        content = findViewById(R.id.content);

    }
}
