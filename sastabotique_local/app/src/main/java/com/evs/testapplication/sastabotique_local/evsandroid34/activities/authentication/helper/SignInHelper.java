package com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.helper;

import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.UserBean;
import com.evs.testapplication.sastabotique_local.evsandroid34.helpers.Utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by AQIB JAVED on 11/24/2018.
 */

public interface SignInHelper {

    static boolean verfiyUserBean(UserBean userBean){
        boolean isValid = false;
        if(!Utils.isNullOrEmptyString(userBean.getUserName()) && !Utils.isNullOrEmptyString(userBean.getPassword())){
            if(Utils.isStartWithUpperCase(userBean.getUserName(),0)){
                isValid = true;
            }
        }
        return false;
    }
    static JSONObject getJsonParse(UserBean bean){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.accumulate("uname",bean.getUserName());
            jsonObject.accumulate("upassword",bean.getPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
