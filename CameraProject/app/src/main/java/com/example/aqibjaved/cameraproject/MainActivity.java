package com.example.aqibjaved.cameraproject;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.CompoundButton;
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
        requestRunTimePermissions();

    }

    private void requestRunTimePermissions() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkSelfPermission(AppConst.permissions[0])!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(AppConst.permissions,AppConst.requestCodeForPermission);
            }else{
                initComponents();
            }
        }else{
            initComponents();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case AppConst.requestCodeForPermission:
                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    initComponents();
                }else{
                    Toast.makeText(this, "Cannot use application without camera permission", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    private void cameraStart(){
        camera= Camera.open();
        parameters= camera.getParameters();
    }

    private void cameraOff(){
        if(camera!=null && parameters!=null) {
            torchOff();
            camera.release();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        cameraOff();
    }

    private void torchOn(){
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();

    }
    private void torchOff(){
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
    }
    private void initComponents() {
    tb=(ToggleButton)findViewById(R.id.tb);
        cameraStart();
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    torchOn();
                }else{
                    torchOff();
                }
            }
        });
    }
}
