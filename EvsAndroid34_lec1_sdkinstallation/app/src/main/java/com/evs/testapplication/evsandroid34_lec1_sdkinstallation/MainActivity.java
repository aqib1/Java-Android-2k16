package com.evs.testapplication.evsandroid34_lec1_sdkinstallation;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private GameSurface gameSurface;
//    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        gameSurface = new GameSurface(getApplicationContext());
        setContentView(gameSurface);
//        setContentView(R.layout.activity_main);
//        initComponents();
//        settingUpListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameSurface.startGame();
    }

    @Override
    protected void onStop() {
        gameSurface.endGame();
        super.onStop();

    }

    //    private void settingUpListeners() {
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Hi there", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void initComponents() {
//     btn = findViewById(R.id.btn1);
//    }

//    public void clickMe(View v){
//        Toast.makeText(MainActivity.this,"Hi there!!",Toast.LENGTH_LONG).show();
//    }
}
