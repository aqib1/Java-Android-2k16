package com.evs.testapplication.evsandroid_batch36;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by AQIB JAVED on 1/5/2019.
 */

public class MusicService extends Service {
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(getApplicationContext(), R.raw.iphone_6_original);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        player = MediaPlayer.create(getApplicationContext(), R.raw.iphone_6_original);
        SmsManager manager = SmsManager.getDefault();

        try {
            manager.sendTextMessage("+923037288990", "+923237811992", "Hi there", null, null);
        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        player.setLooping(true);
        player.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.pause();
        player.seekTo(0);
    }
}
