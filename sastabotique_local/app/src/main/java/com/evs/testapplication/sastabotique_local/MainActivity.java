package com.evs.testapplication.sastabotique_local;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.evs.testapplication.sastabotique_local.CacheManagment.SharedPrefCacheManagment;
import com.evs.testapplication.sastabotique_local.Dao.UserEntityTable;
import com.evs.testapplication.sastabotique_local.Dao.UserTableDao;
import com.evs.testapplication.sastabotique_local.DatabaseContract.DBHelperForUserTable;
import com.evs.testapplication.sastabotique_local.Sqlite2.DBHelper;
import com.evs.testapplication.sastabotique_local.loginModule.SignInActivity;
import com.evs.testapplication.sastabotique_local.test.ListActivityClass;
import com.evs.testapplication.sastabotique_local.test.MediaPlayerActivity;
import com.evs.testapplication.sastabotique_local.test.ServiceActivity;
import com.evs.testapplication.sastabotique_local.test.TestActivity;
import com.evs.testapplication.sastabotique_local.topics.ListCustomActivity;

public class MainActivity extends Activity {
    private TextView splashTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTopTitleBar();
        setContentView(R.layout.activity_main);
        initComponent();
        runtimePermissions();
    }

    private void runtimePermissions() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
             if(checkSelfPermission(AppConts.permissions[0])!= PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(AppConts.permissions[1]) != PackageManager.PERMISSION_GRANTED

                     ){
                requestPermissions(AppConts.permissions,AppConts.requestCodeForRuntimePermissions);
             }else{
                 splashing();
             }
        }
    }

    private void removeTopTitleBar(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void splashing() {






       String csrf= SharedPrefCacheManagment.getSharedPrefCacheManagment()
                .setContext(getApplicationContext())
                .init()
                .get(AppConts.CSRF_TOKKEN_SHARED_PREF_KEY,"Not Found");

        if(csrf.equals("Not Found")){
            Thread t1 = new Thread(()->{
                try {
                    Thread.sleep(5000);
                    UserEntityTable userEntityTable = new UserEntityTable();
                    userEntityTable.setId(1);
                    userEntityTable.setCNIC("jskgkjsgkd");
                    userEntityTable.setName("shjgskjs");
                    userEntityTable.setPassword("s,jgdj");

                    DBHelperForUserTable dbHelperForUserTable
                             = new DBHelperForUserTable(getApplicationContext());
                    try{
                        dbHelperForUserTable.writeData(userEntityTable);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        dbHelperForUserTable.close();
                    }



//                    DBHelper dbHelper = new DBHelper(getApplicationContext());
//                    UserTableDao dao = new UserTableDao();
//                    //setter
//                    try {
//                        dbHelper.insert(dao);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }finally {
//                        dbHelper.close();
//                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(MainActivity.this, MediaPlayerActivity.class);
                startActivity(i);
                finish();
            });
            t1.start();
        }else{//Home Activity
        }

}

    private void initComponent() {
        splashTitle = findViewById(R.id.splashTitle);
        applyingFontsAndStyles();
    }

    private void applyingFontsAndStyles() {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"splash_fonts.ttf");
        this.splashTitle.setTypeface(typeface);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case AppConts.requestCodeForRuntimePermissions:{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    splashing();
                }else{
                    Toast.makeText(this, "Permission Required", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            }
        }
    }
}
