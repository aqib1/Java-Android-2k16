package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AQIB JAVED on 10/6/2018.
 */

public class SettingsActivity extends Activity{
    private String [] menus ={"Home","Contact Us","Settings","Exits"};
    private List<ListEntites> data = new ArrayList<>();
    private CustomAdaptor adaptor;
    private ListView listView;
//    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_listactivity);
//        settingAdaptors();
          settingCustomAdaptorWithData();
    }

    private void settingCustomAdaptorWithData() {
        listView = findViewById(R.id.listview);
        for(int x=0;x<menus.length;x++){
            if(x%2==0){
                data.add(new ListEntites(R.drawable.even,menus[x]));
            }else{
                data.add(new ListEntites(R.drawable.odd,menus[x]));
            }
        }
        adaptor = new CustomAdaptor(getApplicationContext(),data);
        listView.setAdapter(adaptor);


        listView.setOnItemClickListener((adaptorView,view,id,l)->{
            switch (id){
                case 3:
                    finish();
                    break;
                default:
                    Toast.makeText(this, "Clicked "+this.data.get(id).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }


//    private void settingAdaptors() {
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menus);
//        setListAdapter(adapter);
//    }
}
