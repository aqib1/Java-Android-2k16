package com.example.aqibjaved.evsbatch27_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button one,plus,six;
    private EditText input;
    private double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              String number = six.getText().toString();
                input.append(number);
            }
        });

        one.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                String number = one.getText().toString();
                input.append(number);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numb = input.getText().toString();
                input.setText("");
                result += Integer.parseInt(numb);

            }
        });
    }

    private void initComponents() {
        one = (Button)findViewById(R.id.btn_1);
        plus = (Button) findViewById(R.id.btn_plus);
        input = (EditText) findViewById(R.id.input);
        six = (Button) findViewById(R.id.btn_6);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
}
