package com.evs.testapplication.evsandroid_batch36;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by AQIB JAVED on 12/29/2018.
 */

public class FragManagerSingletonClass {
    private static FragManagerSingletonClass fragManagerSingletonClass = null;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private FragManagerSingletonClass(){

    }

    public FragManagerSingletonClass init(Activity activity){
        manager = activity.getFragmentManager();
        transaction = manager.beginTransaction();
        return fragManagerSingletonClass;
    }

    public FragManagerSingletonClass add(Fragment fragment,String tag){
        transaction.add(fragment,tag);
        transaction.commit();
        return fragManagerSingletonClass;
    }

    public FragManagerSingletonClass remove(Fragment fragment){
        transaction.remove(fragment);
        transaction.commit();
        return fragManagerSingletonClass;
    }

    public FragManagerSingletonClass replace(Fragment fragment, int idOfContainer){
        transaction.replace(idOfContainer,fragment);
        transaction.commit();
        return fragManagerSingletonClass;

    }


    public static FragManagerSingletonClass getInstance(){
        if(fragManagerSingletonClass == null) {
          synchronized (FragManagerSingletonClass.class){
              if(fragManagerSingletonClass == null){
                fragManagerSingletonClass = new FragManagerSingletonClass();
              }
          }
        }
        return fragManagerSingletonClass;
    }
}
