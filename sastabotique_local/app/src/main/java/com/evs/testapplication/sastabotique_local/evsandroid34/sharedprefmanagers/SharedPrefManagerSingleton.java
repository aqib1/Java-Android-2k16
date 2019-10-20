package com.evs.testapplication.sastabotique_local.evsandroid34.sharedprefmanagers;

import android.content.Context;
import android.content.SharedPreferences;

import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.UserBean;
import com.evs.testapplication.sastabotique_local.evsandroid34.helpers.ApplicationUtils;

/**
 * Created by AQIB JAVED on 12/15/2018.
 */

public class SharedPrefManagerSingleton {

    private static SharedPrefManagerSingleton sharedPrefManagerSingleton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    private SharedPrefManagerSingleton(){

    }
    public SharedPrefManagerSingleton init(Context context, String title){
        sharedPreferences = context.getSharedPreferences(title,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        return sharedPrefManagerSingleton;
    }

    public SharedPrefManagerSingleton saveData(UserBean userBean) {
        editor.putString(ApplicationUtils.USER_DETAILS_SHARED_PREF_USER_NAME_KEY,userBean.getUserName());
        editor.putString(ApplicationUtils.USER_DETAILS_SHARED_PREF_USER_PASSWORD_KEY,userBean.getPassword());
        editor.commit();
        return sharedPrefManagerSingleton;

    }
    public UserBean getUserBean(){
        UserBean userBean = new UserBean();
        userBean.setUserName(sharedPreferences.getString(ApplicationUtils.USER_DETAILS_SHARED_PREF_USER_NAME_KEY,"Default name"));
        userBean.setPassword(sharedPreferences.getString(ApplicationUtils.USER_DETAILS_SHARED_PREF_USER_PASSWORD_KEY,"Default password"));

        return userBean;
    }

    public static SharedPrefManagerSingleton getInstance(){
           if (sharedPrefManagerSingleton == null)
               synchronized (SharedPrefManagerSingleton.class) {
                   if (sharedPrefManagerSingleton == null)
                   sharedPrefManagerSingleton = new SharedPrefManagerSingleton();
       }
        return sharedPrefManagerSingleton;
    }


}
