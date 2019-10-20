package com.example.aqibjaved.evsbatch27_android;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aqibjaved.evsbatch27_android.com.contants.app.Constants;

/**
 * Created by AQIB JAVED on 3/10/2018.
 */

public class HomeActivity extends Activity {
    private String data[]={"Home","Sign-in","sign-up","exit"};
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initComponents();
//        addingFragment();
//        creatingCache();
    }

    private void initComponents() {
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

    }

    private void creatingCache() {
//        getApplicationContext()


//        FragmentManagment.getInstance().initPreference(getApplicationContext());
//        SharedPreferences preferences = getSharedPreferences(Constants.SIGNUP_CACHE,MODE_PRIVATE);
//        String username = preferences.getString(Constants.KEY_USERNAME,"User name not found");
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString(Constants.KEY_USERNAME,"abc");
//        editor.putString(Constants.KEY_PASSWORD,"abc");
//        editor.commit();



    }

    private void addingFragment() {



        HomeFrag1 frag1 = new HomeFrag1();
        FragmentManagment.getInstance().init(this,R.id.home).replace(frag1);


//                getFragmentManager()
//                .beginTransaction()
//                .add(frag1, HomeFrag1.class.getName())
//                .commit();
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(frag1, HomeFrag1.class.getName());
//        transaction.commit();
    }
}
