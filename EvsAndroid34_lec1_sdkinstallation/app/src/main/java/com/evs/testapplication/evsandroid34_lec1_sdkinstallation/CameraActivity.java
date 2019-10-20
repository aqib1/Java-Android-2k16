package com.evs.testapplication.evsandroid34_lec1_sdkinstallation;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by AQIB JAVED on 10/27/2018.
 */

public class CameraActivity extends Activity {
    private ToggleButton tb_camera;
    private Camera camera;
    private Camera.Parameters param;
    private MediaPlayer player;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        acquiringRuntimePermission();
    }

    private void acquiringRuntimePermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
          if(checkSelfPermission(AppConsts.PERMISSION[0])!= PackageManager.PERMISSION_GRANTED){
              requestPermissions(AppConsts.PERMISSION,AppConsts.REQUEST_CODE_RUNTIME_PERMISSION);
          }else{
              init();
          }
        }else{
            init();
        }
    }
    private void init(){
        settingUpComponents();
        settingUpListeners();
    }
    private void settingUpListeners() {
        tb_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb_camera.isChecked()){
                    torchOn();
                }else{
                    torchOff();

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        initCamera();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseCamera();
    }

    private void initCamera(){
        camera = Camera.open();
        param = camera.getParameters();
    }
    private void releaseCamera(){
        torchOff();
        camera.release();
        player.release();
    }
    private void torchOn() {
        tb_camera.setChecked(true);

        param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(param);
        camera.startPreview();
        player.start();
    }

    private void torchOff() {
        tb_camera.setChecked(false);

        param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(param);
        camera.stopPreview();
        player.pause();
        player.seekTo(0);
    }

    private void settingUpComponents() {
        tb_camera = findViewById(R.id.tb_camera);
        player = MediaPlayer.create(getApplicationContext(),R.raw.iphone_6_original);
        player.setLooping(true);
        
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case AppConsts.REQUEST_CODE_RUNTIME_PERMISSION:{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    init();
                }else{
                    Toast.makeText(this, "Permission Camera required", Toast.LENGTH_SHORT).show();
                    finish();
                }
             break;
            }
        }
    }
}
