package com.evs.testapplication.sastabotique_local;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;

/**
 * Created by AQIB JAVED on 10/27/2018.
 */

public class SlidingDrawerExample extends Activity {
    private SlidingDrawer slidingDrawer;
    private LinearLayout outer,inner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();
    }

    private void initComponents() {
        slidingDrawer = findViewById(R.id.sd1);
        outer = findViewById(R.id.outerContent);
        inner = findViewById(R.id.darwerWrapper);

        slidingDrawer.setOnDrawerOpenListener(()->{
            outer.setClickable(false);
            inner.setClickable(true);
        });

        slidingDrawer.setOnDrawerCloseListener(()->{
            outer.setClickable(true);
            inner.setClickable(false);
        });
    }
}
