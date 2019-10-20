package com.example.aqibjaved.fragmentmanagment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by AQIB JAVED on 11/18/2017.
 */

public class MyFragmentManager {
    private static MyFragmentManager myFragmentManager = null;
    private FragmentManager manager = null;
    private FragmentTransaction transaction = null;
    private Activity activity;
    private int layoutID;
    private MyFragmentManager(){

    }
    public void init(Activity activity,int layoutID){
        this.activity = activity;
        this.layoutID = layoutID;
        manager = activity.getFragmentManager();
        transaction = manager.beginTransaction();
    }
    public MyFragmentManager add(Fragment fragment){
        transaction.add(fragment, fragment.getClass().getName());
        transaction.commit();
        return myFragmentManager;
    }
    public MyFragmentManager remove(Fragment fragment){
        transaction.remove(fragment);
        transaction.commit();
        return myFragmentManager;
    }
    public MyFragmentManager replace(Fragment fragment){
        transaction.replace(layoutID,fragment,fragment.getClass().getName());
        transaction.commit();
        return myFragmentManager;
    }

    public static MyFragmentManager getInstance(){
        if(myFragmentManager == null) myFragmentManager = new MyFragmentManager();
        return myFragmentManager;
    }
}
