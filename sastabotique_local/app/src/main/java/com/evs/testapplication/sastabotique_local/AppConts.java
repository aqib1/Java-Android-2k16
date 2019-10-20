package com.evs.testapplication.sastabotique_local;

import android.Manifest;

/**
 * Created by AQIB JAVED on 9/1/2018.
 */

public interface AppConts {
    String UTF_8="UTF-8";
    String CHARSET_UTF_8="charset="+UTF_8.toLowerCase();
    String CONTENT_TYPE_JSON="application/json";
    String CONTENT_TYPE_PARAM="Content-Type";
    String POST_METHOD="POST";
    String URL="http://192.168.10.3:8080/y/auth/service/login";
    int requestCodeForRuntimePermissions=0;
    String [] permissions = {Manifest.permission.INTERNET,Manifest.permission.SEND_SMS};
    String CSRF_TOKEN_SHARED_PREF="CSRF_TOKEN_SHARED_PREF";
    String CSRF_TOKKEN_SHARED_PREF_KEY="CSRF_TOKKEN_SHARED_PREF_KEY";
    String EDIT_TEXT_KEY_FOR_NAME_BACKUP="EDIT_TEXT_KEY_FOR_NAME_BACKUP";

}
