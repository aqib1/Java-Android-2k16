package com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.SettingsBean;
import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.UserBean;
import com.evs.testapplication.sastabotique_local.evsandroid34.baseadaopters.SettingsBaseAdaptor;
import com.evs.testapplication.sastabotique_local.evsandroid34.fragManagment.FragManager;
import com.evs.testapplication.sastabotique_local.evsandroid34.fragments.NewFeedsFrag;
import com.evs.testapplication.sastabotique_local.evsandroid34.helpers.ApplicationUtils;
import com.evs.testapplication.sastabotique_local.evsandroid34.sharedprefmanagers.SharedPrefManagerSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by AQIB JAVED on 12/8/2018.
 */

public class SettingsActivity extends Activity{
    private String menus[] = {"Home","Login","Register","Exit"};
    private String subMenus[]={"click here to see home page","login here","register here","click here to exit"};
    private List<SettingsBean> settingsBeen = new ArrayList<>();
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        this.listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(),"->{"+this.menus[i]+"}",Toast.LENGTH_LONG).show();

            switch (i){
                case 3:

                    finish();
                    break;
            }

        });
    }

    private void initComponents() {
        listView = findViewById(R.id.setting_panel);

        creatingListData();
        

    }

    public boolean testEven(Predicate<Integer> predicate, int val){
        return predicate.test(val);
    }
    private void creatingListData() {
        if(menus.length!=subMenus.length)
        throw new IllegalStateException("Illegal Menus exits!");
        for(int x=0;x<menus.length;x++){
            SettingsBean bean = new SettingsBean();
            bean.setTitle(menus[x]);
            bean.setSubTitle(subMenus[x]);
            if(testEven(a-> a%2==0, x)){
                bean.setImagePath(R.drawable.even);
            }else{
                bean.setImagePath(R.drawable.odd);
            }
            settingsBeen.add(bean);
        }

        SettingsBaseAdaptor baseAdaptor = new SettingsBaseAdaptor(getApplicationContext(),settingsBeen);
        this.listView.setAdapter(baseAdaptor);

        UserBean userBean = new UserBean();
        userBean.setUserName("ATAB01");
        userBean.setPassword("@13$qw");

        SharedPrefManagerSingleton.getInstance()
        .init(getApplicationContext(), ApplicationUtils.USER_DETAILS_SHARED_PREF)
        .saveData(userBean);
        UserBean userBean1 = SharedPrefManagerSingleton.getInstance().getUserBean();

        NewFeedsFrag frag = new NewFeedsFrag();
        FragManager.getInstance().
                init(this)
                .add(frag,"NewFeedsFrags");
    }
}
