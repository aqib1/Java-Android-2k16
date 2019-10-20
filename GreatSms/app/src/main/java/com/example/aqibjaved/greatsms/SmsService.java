package com.example.aqibjaved.greatsms;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;

/**
 * Created by AQIB JAVED on 9/4/2017.
 */

public class SmsService extends Service implements SmsObserver{
    private Intent filter = new Intent();
    private SmsBroadCastReciever reciever;
    @Override
    public void onCreate() {
        super.onCreate();
        reciever= new SmsBroadCastReciever(this);
        filter.setAction(AppConsts.BROADCAST_MESSAGE);
        IntentFilter filter = new IntentFilter();
        filter.addAction(AppConsts.BROADCAST_MESSAGE);
        registerReceiver(reciever,filter);
    }

    @Override
    public void onDestroy() {
        stopServiceSetup();
        super.onDestroy();
        unregisterReceiver(reciever);
    }
    private void stopServiceSetup(){
//        try {
            handler.setStopSendingMessage(true);
//            handler.stopSendingMessageThread();
//        } catch (InterruptedException e) {
//            IObserver(e.getMessage());
//        }
    }
    private SmsHandler handler;
    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Thread thread =new Thread(()->{
            if(intent!=null) {
                String fileName = intent.getStringExtra(AppConsts.KEY_PATH);
                String message = intent.getStringExtra(AppConsts.KEY_MESSAGE);
                try {
                    handler = new SmsHandler(getApplicationContext(),fileName,message,this);
                    handler.sendMessages();
                }catch (Exception e){
                    IObserver("Message failed !! "+e.getMessage());
                }
            }});
            thread.start();
            return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void IObserver(String message) {
        filter.putExtra(AppConsts.KEY_BROADCAST,message);
        sendBroadcast(filter);
    }
}
