package com.example.aqibjaved.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AQIB JAVED on 10/28/2017.
 */

public class SharedPrefManagment {
    private static SharedPrefManagment preferences;
    private SharedPreferences sharedPreferences;
    private  SharedPrefManagment(){
    }
    //initailizing context and preference object
    public SharedPrefManagment init(Context context){
        if(sharedPreferences==null)
        sharedPreferences = context.getSharedPreferences(Credentials.name,Context.MODE_PRIVATE);
        return preferences;
    }
    //inserting value in xml file
    public SharedPrefManagment insert(LoginBean bean){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(Credentials.KEY_USERNAME,bean.getUser_name());
        editor.putString(Credentials.KEY_PASSWORD,bean.getPassword());
        editor.commit();
        return preferences;
    }

    //reading values from xml file
    public LoginBean read(){
      LoginBean login= new LoginBean();
        login.setUser_name(sharedPreferences.getString(Credentials.KEY_USERNAME,"NOT FOUND"));
        login.setPassword(sharedPreferences.getString(Credentials.KEY_PASSWORD,"NOT FOUND"));
        return login;
    }

    //returning the singleton object of class
    public static SharedPrefManagment getInstance(){
        if(preferences  == null){
            preferences= new SharedPrefManagment();
        }
        return preferences;
    }

    interface Credentials{
        String name="USER_PREF_CREDENTIALS";
        String KEY_USERNAME="KEY_USERNAME";
        String KEY_PASSWORD="KEY_PASSWORD";
    }
}
