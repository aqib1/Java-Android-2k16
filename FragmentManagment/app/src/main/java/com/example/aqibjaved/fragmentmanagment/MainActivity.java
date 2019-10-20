package com.example.aqibjaved.fragmentmanagment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addingFragments();
    }

    private void addingFragments() {
        MyFragmentManager.getInstance()
                .init(this,R.id.mainLayout);
        MyFragment1 fragment1 = new MyFragment1();
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(fragment1,MyFragment1.class.getName());
//        transaction.commit();
        MyFragmentManager.getInstance().replace(fragment1);
    }
}
