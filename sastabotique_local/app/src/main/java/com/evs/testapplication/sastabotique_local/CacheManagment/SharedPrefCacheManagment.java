package com.evs.testapplication.sastabotique_local.CacheManagment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.evs.testapplication.sastabotique_local.AppConts;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by AQIB JAVED on 9/9/2018.
 */

public class SharedPrefCacheManagment implements Cloneable,Serializable{
    private static SharedPrefCacheManagment sharedPrefCacheManagment = null;
    private Context context;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private SharedPrefCacheManagment(){
    }
    public SharedPrefCacheManagment setContext(Context context){
        this.context = context;
        return sharedPrefCacheManagment;
    }
    public SharedPrefCacheManagment init(){
        sp = this.context.getSharedPreferences(AppConts.CSRF_TOKEN_SHARED_PREF,context.MODE_PRIVATE);
        editor = this.sp.edit();
        return sharedPrefCacheManagment;
    }
    public SharedPrefCacheManagment save(String key,@Nullable String val){
        this.editor.putString(key,val);
        this.editor.commit();
        return sharedPrefCacheManagment;
    }
    @Nullable
    public String get(String key, String defaultMessage){
        return this.sp.getString(key,defaultMessage);
    }

    @Override
    protected SharedPrefCacheManagment clone() throws CloneNotSupportedException {
        return sharedPrefCacheManagment;
    }

    protected SharedPrefCacheManagment readResolve(){
        return sharedPrefCacheManagment;
    }

    public static SharedPrefCacheManagment getSharedPrefCacheManagment(){
        if(Objects.isNull(sharedPrefCacheManagment)) {
            synchronized (SharedPrefCacheManagment.class) {
                if (Objects.isNull(sharedPrefCacheManagment)) {
                    sharedPrefCacheManagment = new SharedPrefCacheManagment();
                }
            }
        }
        return sharedPrefCacheManagment;
    }
}
