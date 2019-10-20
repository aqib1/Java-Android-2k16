package com.evs.testapplication.sastabotique_local.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;

/**
 * Created by AQIB JAVED on 11/17/2018.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
//        SmsManager smsManager = SmsManager.getDefault();
//        smsManager.sendTextMessage("+923237811992","+926538365831","hi there",null,null);
        return START_STICKY;
    }
}

