package com.example.aqibjaved.greatsms;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by AQIB JAVED on 9/4/2017.
 */

public class SmsBroadCastReciever extends BroadcastReceiver {
    private Context context;
    public SmsBroadCastReciever(){}
    public SmsBroadCastReciever(Context context){
        this.context=context;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(AppConsts.BROADCAST_MESSAGE)){
            String message= intent.getStringExtra(AppConsts.KEY_BROADCAST);
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.mipmap.logo)
                            .setContentTitle("Message Status")
                            .setContentText(message);
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());
        }
    }
}
