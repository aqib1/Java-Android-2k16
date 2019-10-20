package com.service;

import com.models.SignIn;

/**
 * Created by AQIB JAVED on 10/8/2017.
 */

public class SignInService {
    private String user_name="EVS";
    private String password="123";
    public boolean verifyCredentials(SignIn model){
        if(model.getUsername().equals(user_name) && model.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
