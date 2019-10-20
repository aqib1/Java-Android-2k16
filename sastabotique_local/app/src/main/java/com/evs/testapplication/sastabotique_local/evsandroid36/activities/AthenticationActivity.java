package com.evs.testapplication.sastabotique_local.evsandroid36.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;

import com.evs.testapplication.sastabotique_local.CacheManagment.SharedPrefCacheManagment;
import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.evsandroid34.sharedprefmanagers.SharedPrefManagerSingleton;
import com.evs.testapplication.sastabotique_local.evsandroid36.dto.LoginDto;
import com.evs.testapplication.sastabotique_local.evsandroid36.dto.Response;
import com.evs.testapplication.sastabotique_local.evsandroid36.httpclients.AuthHttpClient;
import com.evs.testapplication.sastabotique_local.evsandroid36.utilities.IHelper;

import java.util.concurrent.ExecutionException;

/**
 * Created by AQIB JAVED on 1/20/2019.
 */

public class AthenticationActivity extends Activity{

    private LinearLayout signInForm, registrationForm;
    private SlidingDrawer slidingDrawer;
    private EditText userId, password, r_userId, r_password;
    private Button signIn, register;
    private ImageView handle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.athentication_activity);
        initComponents();
        settingDrawerEvents();
        settingUpListeners();
    }

    private void settingUpListeners() {

        signIn.setOnClickListener((q) ->{
            LoginDto loginDto = new LoginDto();
            loginDto.setUserName(this.userId.getText().toString());
            loginDto.setUserPassword(this.password.getText().toString());
            Log.d("USER - LOGIN - DTO", loginDto.toString());
            if(IHelper.isValidLoginDto(loginDto)){
                runOnUiThread(()->{
                    AuthHttpClient authHttpClient = new AuthHttpClient();
                    authHttpClient.execute(loginDto);
                    try {
                        Response response = authHttpClient.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    SharedPrefCacheManagment
                            .getSharedPrefCacheManagment()
                            .init()
                            .save(IHelper.KEY_AUTH_USERID,loginDto.getUserName())
                            .save(IHelper.KEY_AUTH_PASSID,loginDto.getUserPassword());

                });
            }
        });
    }

    private void settingDrawerEvents() {
        slidingDrawer.setOnDrawerOpenListener(() -> {
            registrationForm.setClickable(true);
            signInForm.setClickable(false);
        });
        slidingDrawer.setOnDrawerCloseListener(() -> {
            signInForm.setClickable(true);
            registrationForm.setClickable(false);
        });
    }

    private void initComponents() {
        slidingDrawer = findViewById(R.id.auth_signupdrawer);
        userId = findViewById(R.id.auth_username_edittext);
        r_userId = findViewById(R.id.auth_r_username);
        password = findViewById(R.id.auth_password_edittext);
        r_password = findViewById(R.id.auth_r_password);
        handle = findViewById(R.id.auth_handle);
        signIn = findViewById(R.id.auth_signin_edittext);
        register = findViewById(R.id.auth_register);
        registrationForm = findViewById(R.id.auth_registerform);
        signInForm = findViewById(R.id.auth_signinactivity_form);

    }
}
