package com.example.aqibjaved.torchandsmsapp;

import android.Manifest;

/**
 * Created by AQIB JAVED on 3/16/2018.
 */

public interface Constants {
    int requestCodeForRuntimePermissions=0;
    String [] runtimePermissions= {Manifest.permission.CAMERA,Manifest.permission.SEND_SMS};
}
