package com.example.aqibjaved.evsbatch27_android.com.signup.validators;

import com.example.aqibjaved.evsbatch27_android.com.contants.app.Constants;
import com.example.aqibjaved.evsbatch27_android.com.model.signup.User;

/**
 * Created by AQIB JAVED on 3/4/2018.
 */

public class SignUpValidator {
    public boolean isValidUserName(User user){
        return Character.isLetter(user.getName().charAt(Constants.indexForUserNameValidationCriteria));
    }
    public boolean isValidPassword(User user){
        return user.getPassword().length() >= Constants.passwordMaxLength && user.getPassword().equals(user.getConfirmPassword());
    }
    public boolean isValidNumber(User user){
        return user.getContactNumber().length() == Constants.validNumberMinLength;
    }

    public boolean allFiledEntered(User user){
        return !user.isEmpty();
    }

}
