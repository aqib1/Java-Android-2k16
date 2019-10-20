package com.evs.testapplication.sastabotique_local.evsandroid34.fragManagment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;

/**
 * Created by AQIB JAVED on 12/22/2018.
 */

public class FragManager {
    private static FragManager fragManager = null;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private FragManager(){

    }
    public FragManager init(Activity context){
        this.fragmentManager = context.getFragmentManager();
        this.transaction = this.fragmentManager.beginTransaction();
        return fragManager;
    }

    public FragManager add(Fragment fragment, String param){
        this.transaction.add(fragment,param);
        this.transaction.commit();
        return fragManager;
    }

    public FragManager remove(Fragment fragment){
        this.transaction.remove(fragment);
        this.transaction.commit();
        return fragManager;
    }

    public FragManager replace(int parentId,Fragment fragment){
        this.transaction.replace(parentId,fragment);
        this.transaction.commit();
        return fragManager;
    }

    public static FragManager getInstance(){
        if(fragManager == null){
            synchronized (FragManager.class){
                if(fragManager == null){
                    fragManager = new FragManager();
                }

            }
        }
        return fragManager;
    }



}
