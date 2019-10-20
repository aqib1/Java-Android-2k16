package com.example.aqibjaved.evsbatch27_android;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;

/**
 * Created by AQIB JAVED on 3/10/2018.
 */

public class FragmentManagment {
    private static FragmentManagment managment=null;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private int id;
    private FragmentManagment(){

    }
    public FragmentManagment init(Activity activity,int id){
        manager=activity.getFragmentManager();
        transaction = manager.beginTransaction();
        this.id=id;
        return managment;
    }

    public FragmentManagment add(Fragment fragment){
        transaction.add(fragment,fragment.getClass().getName());
        transaction.commit();
        return managment;
    }
    public FragmentManagment remove(Fragment fragment){
        transaction.remove(fragment);
        transaction.commit();
        return managment;
    }
    public FragmentManagment replace(Fragment fragment){
        transaction.replace(id,fragment);
        transaction.commit();
        return managment;
    }

    public void initPreference(Context context){
//        context.getSharedPreferences()
    }

    public static FragmentManagment getInstance() {
        if(managment == null) managment = new FragmentManagment();
        return managment;
    }
}
