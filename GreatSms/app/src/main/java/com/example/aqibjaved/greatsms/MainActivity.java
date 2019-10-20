package com.example.aqibjaved.greatsms;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

public class MainActivity extends Activity {
    private boolean moveToNext=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingUpWindowFeatures();
        setContentView(R.layout.activity_main);
        splashActions();
    }

    private void splashActions() {
        Thread thread = new Thread(()->{
                try {
                    Thread.sleep(getResources().getInteger(R.integer.splash_sleep));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isRunning(MainActivity.this)){
                    Intent intent= new Intent(MainActivity.this,GreatSmsHome.class);
                    startActivity(intent);
                    finish();
                }
        });thread.start();

    }
    public boolean isRunning(Context ctx) {
        ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

        for (ActivityManager.RunningTaskInfo task : tasks) {
            if (ctx.getPackageName().equalsIgnoreCase(task.baseActivity.getPackageName()))
                return true;
        }

        return false;
    }
    private void settingUpWindowFeatures() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onStop() {
        super.onStop();
        moveToNext=false;
    }
}
