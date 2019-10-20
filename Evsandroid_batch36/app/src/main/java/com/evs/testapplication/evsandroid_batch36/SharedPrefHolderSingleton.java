package com.evs.testapplication.evsandroid_batch36;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AQIB JAVED on 12/22/2018.
 */

public class SharedPrefHolderSingleton {
    private static SharedPrefHolderSingleton sharedPrefHolderSingleton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private SharedPrefHolderSingleton(){

    }

    public SharedPrefHolderSingleton init(Context context){
        this.sharedPreferences = context.getSharedPreferences(AppConsts.SHARED_PREF_USER_CRED_CAHED_FILE,Context.MODE_PRIVATE);
        this.editor = this.sharedPreferences.edit();
        return sharedPrefHolderSingleton;
    }
    public void save(UserBean bean){
        this.editor.putString(AppConsts.SHARED_PREF_USER_NAME_KEY, bean.getUsername());
        this.editor.putString(AppConsts.SHARED_PREF_USER_PASSWORD_KEY,bean.getPassword());
        this.editor.commit();
    }
    public UserBean getData(){
        String username = this.sharedPreferences.getString(AppConsts.SHARED_PREF_USER_NAME_KEY,"DEFAULT VALUE");
        String password = this.sharedPreferences.getString(AppConsts.SHARED_PREF_USER_PASSWORD_KEY,"DEFAULT VALUE");
        return new UserBean(username, password);
    }

    public static SharedPrefHolderSingleton getInstance(){
        if(sharedPrefHolderSingleton == null){
            synchronized (SharedPrefHolderSingleton.class){
                if(sharedPrefHolderSingleton == null){
                    sharedPrefHolderSingleton = new SharedPrefHolderSingleton();
                }
            }
        }
        return sharedPrefHolderSingleton;
    }


}
