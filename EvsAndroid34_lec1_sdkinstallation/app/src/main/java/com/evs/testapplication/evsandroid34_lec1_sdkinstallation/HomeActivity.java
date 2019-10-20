package com.evs.testapplication.evsandroid34_lec1_sdkinstallation;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by AQIB JAVED on 10/28/2018.
 */

public class HomeActivity extends Activity {
    private EditText editTextName;
    private LinearLayout fragmentContainer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("username",editTextName.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        String userName = savedInstanceState.getString("username");
        editTextName.setText(userName);
    }

    private void initComponents() {
        editTextName = findViewById(R.id.nameInput);
        MyFragment myFragment = new MyFragment();
        fragmentContainer = findViewById(R.id.fragmentContainer);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(myFragment,"MY FRAGMENT");
        transaction.replace(R.id.fragmentContainer,myFragment);
        transaction.commit();
        MyFragment myFragment1 = new MyFragment();
        transaction.replace(R.id.fragmentContainer,myFragment1);
        transaction.commit();
//        transaction.remove(myFragment);
//        transaction.add(myFragment1, "MY FRAGMENT");
//        transaction.commit();



//        SharedPreferences preferences = getSharedPreferences("USER_PREF",MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("USRE_NAME","aqib");
//        editor.putInt("PASSWORD",1234);
//        editor.commit();



    }
    public void readPreference(){
        SharedPreferences preferences = getSharedPreferences("USER_PREF",MODE_PRIVATE);
        String username =preferences.getString("USRE_NAME","NOT FOUND");
        int password = preferences.getInt("PASSWORD",-1);


    }
}
