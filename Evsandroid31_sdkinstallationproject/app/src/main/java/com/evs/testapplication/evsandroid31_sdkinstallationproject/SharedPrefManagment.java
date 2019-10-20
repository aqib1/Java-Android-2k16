package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by AQIB JAVED on 10/14/2018.
 */

public class SharedPrefManagment {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static SharedPrefManagment sharedPrefManagment;
    private SharedPrefManagment(){

    }

    public SharedPrefManagment init(Context context){
        sharedPreferences = context.getSharedPreferences(AppConsts.USER_CREDENTIALS_SHARED_PREF,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        return  sharedPrefManagment;
    }
    public SharedPrefManagment savePref(HashMap<String,String> data){
        Set<String> keys = data.keySet();
        for(String key:keys){
            editor.putString(key,data.get(key));
        }
        editor.commit();
        return sharedPrefManagment;
    }

    public static SharedPrefManagment getInstance(){
        if(sharedPrefManagment == null){
            synchronized (SharedPrefManagment.class){
                if(sharedPrefManagment == null)
                    sharedPrefManagment = new SharedPrefManagment();
            }

        }
        return sharedPrefManagment;
    }
}
