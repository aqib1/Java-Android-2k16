package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.Manifest;

/**
 * Created by AQIB JAVED on 10/13/2018.
 */

public interface AppConsts {
    String KEY_USER_CREDENTIALS_SHARED_PREF_USERPASSWORD="KEY_USER_CREDENTIALS_SHARED_PREF_USERPASSWORD";
    String KEY_USER_CREDENTIALS_SHARED_PREF_USERNAME="KEY_USER_CREDENTIALS_SHARED_PREF_USERNAME";
    String USER_CREDENTIALS_SHARED_PREF = "USER_CREDENTIALS_SHARED_PREF";
    int idForRunTimePermission = 0;
    String [] permissions = {Manifest.permission.CAMERA};
}
