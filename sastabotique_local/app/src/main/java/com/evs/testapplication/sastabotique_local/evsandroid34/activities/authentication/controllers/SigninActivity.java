package com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.Toast;

import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.evsandroid34.Database.helper.SqliteHelper;
import com.evs.testapplication.sastabotique_local.evsandroid34.Responses.UserResponse;
import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.UserBean;
import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.helper.SignInHelper;
import com.evs.testapplication.sastabotique_local.evsandroid34.asyncTasks.SigninTask;
import com.evs.testapplication.sastabotique_local.evsandroid34.bean.LoginBean;

import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by AQIB JAVED on 11/24/2018.
 */

public class SigninActivity extends Activity {
    private SlidingDrawer drawer = null;
    private LinearLayout singinForm = null;
    private LinearLayout registerForm = null;
    private ImageView handle = null;
    private EditText userName, password,r_username,r_password;
    private Button submit,register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinactivity_layout);
        initComponents();
        settingUpListeners();
    }

    private void settingUpListeners() {
        drawer.setOnDrawerOpenListener(() -> {
            singinForm.setClickable(false);
            registerForm.setClickable(true);
            handle.setImageResource(R.drawable.double_down);
        });

        drawer.setOnDrawerCloseListener(()->{
            singinForm.setClickable(true);
            registerForm.setClickable(false);
            handle.setImageResource(R.drawable.double_up);
        });


        SqliteHelper helper = new SqliteHelper(getApplicationContext());
        LoginBean loginBean = new LoginBean();
        loginBean.setUserName("Test");
        loginBean.setUserPassword("Test123");
        helper.save(loginBean);
        List<LoginBean> data = helper.getLoginInfo();

        helper.close();






        register.setOnClickListener((e)->{
            UserBean userBean = new UserBean();
            userBean.setUserName(r_username.getText().toString());
            userBean.setPassword(r_password.getText().toString());
            if(SignInHelper.verfiyUserBean(userBean)){
                // Restful api connectivity
                runOnUiThread(()->{
                    JSONObject request = SignInHelper.getJsonParse(userBean);
                    SigninTask signinTask = new SigninTask();
                    signinTask.execute(request);

                    try {
                        UserResponse response = signinTask.get();
                        //perform different operation on UserResponse
                        ///
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    } catch (ExecutionException e1) {
                        e1.printStackTrace();
                    }
                });
            }

        });

        submit.setOnClickListener((e)->{
            UserBean userBean = new UserBean();
            userBean.setUserName(userName.getText().toString());
            userBean.setPassword(password.getText().toString());
            if(SignInHelper.verfiyUserBean(userBean)){
                JSONObject request = SignInHelper.getJsonParse(userBean);
                //restful api connectivitys

            }else{
                Toast.makeText(this, "Please fill all fields according rules", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initComponents() {
        submit = findViewById(R.id.signin_btn);
        userName = findViewById(R.id.username_edittext);
        password = findViewById(R.id.password_edittext);
        drawer = findViewById(R.id.signupdrawer1);
        singinForm = findViewById(R.id.signinactivity_form);
        registerForm = findViewById(R.id.registerform);
        handle = findViewById(R.id.auth_handle);
        register = findViewById(R.id.register);
        r_username = findViewById(R.id.r_username);
        r_password = findViewById(R.id.r_password);

    }
}
