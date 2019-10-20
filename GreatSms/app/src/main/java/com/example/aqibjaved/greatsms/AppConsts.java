package com.example.aqibjaved.greatsms;


import android.Manifest;

/**
 * Created by AQIB JAVED on 9/4/2017.
 */

public class AppConsts {
    /**
     * JavaDoc
     * @since 1.0 Great Sms app
     * @author Aqib Javed
     * */
    public static final int MESSAGE_PERMISSION_CODE = 0;
    public static final String[] permissions={Manifest.permission.SEND_SMS,Manifest.permission.READ_EXTERNAL_STORAGE};
    public static final String KEY_PATH="KEY_PATH";
    public static final String KEY_MESSAGE="KEY_MESSAGE";
    public static final String KEY_BROADCAST="KEY_BROADCAST";
    public static final String BROADCAST_MESSAGE="com.itro.greatSms.BroadCast";
}
