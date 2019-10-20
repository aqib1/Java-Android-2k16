package com.evs.testapplication.sastabotique_local.evsandroid34.helpers;

/**
 * Created by AQIB JAVED on 11/24/2018.
 */

public class Utils {
    private Utils(){

    }

    public static boolean isNullOrEmptyString(String data){
        return data == null || data.isEmpty();
    }

    public static boolean isStartWithUpperCase(String data, int indexOfLetter){
        return Character.isUpperCase(data.charAt(indexOfLetter));
    }
}
