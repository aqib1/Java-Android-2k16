package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ToggleButton;

import java.util.HashMap;

/**
 * Created by AQIB JAVED on 10/13/2018.
 */

public class CameraActivity extends Activity{
    private ToggleButton torchbtn;
    private Camera camera;
    private Camera.Parameters parameters;
    private MediaPlayer player;
    private FragmentManager manager;
//    private SharedPreferences preferences;
//    private SharedPreferences.Editor editor;
//    private String username = "abc";
//    private String userpassword="abc123";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        torchbtn.setOnClickListener((V)->{
            if(torchbtn.isChecked()){
                torchOn();
            }else{
                torchOff();
            }

        });
    }
    public void torchOn(){
        this.parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        this.camera.setParameters(this.parameters);
        this.camera.startPreview();
        player.setLooping(true);
        player.start();
    }

    public void torchOff(){
        this.parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        this.camera.setParameters(this.parameters);
        this.camera.stopPreview();
        player.seekTo(0);
        player.pause();
    }

    public void initCamera(){
        this.camera = Camera.open();
        this.parameters = this.camera.getParameters();
        player = MediaPlayer.create(getApplicationContext(),R.raw.iphone_6_original);
    }
    public void stopCamera(){
        if(torchbtn.isChecked()){
            torchOff();
            torchbtn.setChecked(false);
        }
        this.camera.release();
        player.release();
    }
    @Override
    protected void onStart() {
        super.onStart();
        initCamera();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCamera();
    }

    private void initComponents() {
        torchbtn = findViewById(R.id.tb_1);

//        manager = getFragmentManager();
//        MyFragment myFragment = new MyFragment();
//        FragmentTransaction transaction = manager.beginTransaction();
//
//            transaction.replace(R.id.llforFrag,myFragment);
//        transaction.commit();
//        transaction.add(myFragment,"myfrag");
//        transaction.remove(myFragment);



//        HashMap<String,String> map = new HashMap<>();
//        map.put(AppConsts.KEY_USER_CREDENTIALS_SHARED_PREF_USERNAME,"Ali");
//        map.put(AppConsts.KEY_USER_CREDENTIALS_SHARED_PREF_USERPASSWORD,"ali123");
//        SharedPrefManagment
//                .getInstance()
//                .init(getApplicationContext())
//                .savePref(map);
        //preferences = getSharedPreferences(AppConsts.USER_CREDENTIALS_SHARED_PREF,MODE_PRIVATE);
        //editor = preferences.edit();
        //editor.putString(AppConsts.KEY_USER_CREDENTIALS_SHARED_PREF_USERNAME,username);
        //editor.putString(AppConsts.KEY_USER_CREDENTIALS_SHARED_PREF_USERPASSWORD,userpassword);
        //editor.commit();

        //String username = preferences.getString(AppConsts.KEY_USER_CREDENTIALS_SHARED_PREF_USERNAME,"No found");

    }
}
