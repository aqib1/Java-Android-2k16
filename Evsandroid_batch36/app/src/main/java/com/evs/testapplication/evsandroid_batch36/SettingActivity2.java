package com.evs.testapplication.evsandroid_batch36;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AQIB JAVED on 12/9/2018.
 */

public class SettingActivity2 extends Activity {
    private ListView listView = null;
    private String[] settingsMenus =
            {"Wifi", "Sim card","BT","Data Usage","Display brightness","Exit"};
    private String[] subMenus = {"wifi settings","sim card settings","BT & BLE","data usage stats","display brightness stats","exit here"};
//    private ArrayAdapter<String> adapter = null;
    private List<SettingBean> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity2);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }


    private void initComponents() {
        listView = findViewById(R.id.listView);


        Setting2Adaptor setting2Adaptor = new Setting2Adaptor(getApplicationContext(), data);
        listView.setAdapter(setting2Adaptor);

    }

    private void initListData() {
        if(settingsMenus.length!=subMenus.length){
            throw new IllegalStateException("Menus are not in valid form");
        }
        if(settingsMenus.length == 0){
            throw new IllegalStateException("Menus cannot be empty");
        }
        data = new ArrayList<>();
        for(int index=0;index<settingsMenus.length;index++){
            SettingBean settingBean = new SettingBean();
            settingBean.setTitle(this.settingsMenus[index]);
            settingBean.setSubTitle(this.subMenus[index]);
            if(isEven(index)){
                settingBean.setImageSrc(R.drawable.even);
            }else{
                settingBean.setImageSrc(R.drawable.odd);
            }
            data.add(settingBean);
        }
    }

    public boolean isEven (Integer val){
        return val%2==0;
    }
}
