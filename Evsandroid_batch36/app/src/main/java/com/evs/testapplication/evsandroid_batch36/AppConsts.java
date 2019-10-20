package com.evs.testapplication.evsandroid_batch36;

/**
 * Created by AQIB JAVED on 12/22/2018.
 */

public class AppConsts {

    private AppConsts(){

    }


    public static final String SHARED_PREF_USER_CRED_CAHED_FILE="SHARED_PREF_USER_CRED_CAHED_FILE";
    public static final String SHARED_PREF_USER_NAME_KEY="SHARED_PREF_USER_NAME_KEY";
    public static final String SHARED_PREF_USER_PASSWORD_KEY="SHARED_PREF_USER_PASSWORD_KEY";
    public static final String FRAGMENT_NOTIFICATION_NAME="FRAGMENT_NOTIFICATION_NAME";

    public static boolean isEmptyOrNullString(String val){
        return val == null || val.isEmpty();
    }



}
