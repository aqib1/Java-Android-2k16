package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by AQIB JAVED on 9/29/2018.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        runtimePermissions();
    }

    private void runtimePermissions() {
     if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
         if(checkSelfPermission(AppConsts.permissions[0])!= PackageManager.PERMISSION_GRANTED){
             requestPermissions(AppConsts.permissions,AppConsts.idForRunTimePermission);
         }else{
             settingUpSplash();
         }
     }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case AppConsts.idForRunTimePermission:{
                if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Camera permission required", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    settingUpSplash();
                }

                break;
            }
        }
    }

    private void settingUpSplash() {
     Thread t1 = new Thread(()->{
         try {
             TimeUnit.SECONDS.sleep(5);
//             Intent intent = new Intent(SplashActivity.this,MainActivity.class);
//             Intent intent = new Intent("com.evs.testapplication.evsandroid31.MAIN_ACTIVITY");
             Intent intent = new Intent(SplashActivity.this,CameraActivity.class);
             startActivity(intent);


             finish();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     });t1.start();
    }
}
