package com.evs.testapplication.sastabotique_local.evsandroid36.utilities;

import com.evs.testapplication.sastabotique_local.evsandroid36.dto.LoginDto;

/**
 * Created by AQIB JAVED on 1/20/2019.
 */

public interface IHelper {

    String KEY_AUTH_USERID="KEY_AUTH_USERID";
    String KEY_AUTH_PASSID = "KEY_AUTH_PASSID";

    static boolean isEmptyOrNullString(String data){
        return data == null || data.isEmpty();
    }
    static boolean isValidLoginDto(LoginDto loginDto){
        return !isEmptyOrNullString(loginDto.getUserName()) && !isEmptyOrNullString(loginDto.getUserPassword());
    }
}
