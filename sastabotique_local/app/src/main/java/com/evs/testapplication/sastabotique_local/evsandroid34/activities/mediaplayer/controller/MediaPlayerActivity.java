package com.evs.testapplication.sastabotique_local.evsandroid34.activities.mediaplayer.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ToggleButton;

import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.evsandroid34.service.MusicService;

/**
 * Created by AQIB JAVED on 12/23/2018.
 */

public class MediaPlayerActivity extends Activity {
    private ToggleButton playerBtn;
    private Intent serviceIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_player_layout);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        playerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playerBtn.isChecked()){
                    startService(serviceIntent);
                }else{
                    stopService(serviceIntent);
                }
            }
        });
    }

    private void initComponents() {
        playerBtn = findViewById(R.id.playerbtn);
        serviceIntent = new Intent(this,MusicService.class);
    }
}
