package com.evs.testapplication.sastabotique_local.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.evs.testapplication.sastabotique_local.R;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

public class MusicService extends Service{
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
            if(!player.isPlaying() && !player.isLooping()) {
                player.setLooping(true);
                player.start();
            }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(getApplicationContext(),R.raw.iphone_6_original);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }
}
