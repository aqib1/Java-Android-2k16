package com.evs.testapplication.sastabotique_local.test;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.ListView;

import com.evs.testapplication.sastabotique_local.AppConts;
import com.evs.testapplication.sastabotique_local.R;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by AQIB JAVED on 9/15/2018.
 */

//public class ListActivityClass extends ListActivity {

    public class ListActivityClass extends Activity{
    private String[] menus= {"Home","Client details","Products details","Shippments","Setting","Exit"};
    private ListActivityClassAdopter adopter;
    private EditText name;
    private ListView listView;
    private ArrayList<ListActivityEntityClass> data;
    private MediaPlayer mediaPlayer;
    private SmsManager smsManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivityclasslayout);
        settingUpListData();
        initComponents();
        settingUpListener();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString(AppConts.EDIT_TEXT_KEY_FOR_NAME_BACKUP);
        if(!Objects.isNull(name) && !name.isEmpty()){
            this.name.setText(name);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(!this.name.getText().toString().isEmpty()){
            outState.putString(AppConts.EDIT_TEXT_KEY_FOR_NAME_BACKUP,name.getText().toString());
        }
    }

    private void settingUpListener() {

        listView.setOnItemClickListener((lview,view,position,id)->{
            switch (position){
                case 5:{
                    finish();
                    break;
                }
            }

        });
    }

    private boolean testEven(Predicate<Integer> predicate,int val){
        return predicate.test(val);
    }
    private void settingUpListData() {
        data = new ArrayList<>();

        for(int x=0;x<menus.length;x++){
            if(testEven(y->y%2==0,x+1)){
                data.add(new ListActivityEntityClass(R.drawable.even,menus[x]));
            }else{
                data.add(new ListActivityEntityClass(R.drawable.odd,menus[x]));
            }
        }
    }

    private void initComponents() {
        listView = findViewById(R.id.listview_menus);
        adopter = new ListActivityClassAdopter(data,getApplicationContext());
        listView.setAdapter(adopter);
        name = findViewById(R.id.edittext_name);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.iphone_6_original);
        smsManager = SmsManager.getDefault();
        MyFragment1 myFragment1 = new MyFragment1();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.linear_frag1,myFragment1);
        transaction.commit();


//        transaction.add(myFragment1,"myfrag1");

//        transaction.remove(myFragment1);
//        transaction.commit();




        try{
//            smsManager.sendTextMessage("+923237811992",null,"Hi there",null,null);
        }catch(Exception e){

        }


//        mediaPlayer.start();
//        mediaPlayer.seekTo(0);
////        mediaPlayer.pause();
//        if(mediaPlayer.isPlaying()){
//            mediaPlayer.stop();
//        }






//        adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,menus);
//        setListAdapter(adapter);

    }

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        switch (position){
//            case 5:{
//                finish();
//                break;
//            }
//            case 0:{
//
//                break;
//            }
//
//        }
//    }
}
