package com.example.aqibjaved.torchapptest;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    private ToggleButton tb;
    private Camera camera;
    private Camera.Parameters parameters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkingRuntimePermissions();
        initComponents();
        settingUplisteners();
    }

    private void settingUplisteners() {
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb.isChecked()){
                    torchOn();
                }else{
                    torchOff();
                }
            }
        });
    }

    private void initCamera(){
        camera = Camera.open();
        parameters= camera.getParameters();
    }

    @Override
    protected void onStop() {
        super.onStop();
        torchOff();
    }

    private void torchOff() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
        tb.setChecked(false);
    }

    private void torchOn() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    private void initComponents() {
        tb= findViewById(R.id.tb_1);
    }

    private void checkingRuntimePermissions() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Constants.runtimePermission[0]) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(Constants.runtimePermission,Constants.requestCodeForRuntimePermissions);
            }else{
                initCamera();
            }
        }else{
            initCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case Constants.requestCodeForRuntimePermissions:{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initCamera();
                }else{
                    Toast.makeText(this, "You cannot use this app without camera permission", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
            }
        }

    }
}
