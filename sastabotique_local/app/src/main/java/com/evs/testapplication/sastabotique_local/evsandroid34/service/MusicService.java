package com.evs.testapplication.sastabotique_local.evsandroid34.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.evs.testapplication.sastabotique_local.R;

/**
 * Created by AQIB JAVED on 12/23/2018.
 */

public class MusicService extends Service {
    private MediaPlayer player = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        initMediaPlayer();
        return START_STICKY;
    }

    private void initMediaPlayer() {
        player = MediaPlayer.create(getApplicationContext(),R.raw.iphone_6_original);
        player.start();
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();

    }
}
