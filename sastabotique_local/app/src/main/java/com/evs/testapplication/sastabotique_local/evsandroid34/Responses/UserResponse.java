package com.evs.testapplication.sastabotique_local.evsandroid34.Responses;

import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.UserBean;

/**
 * Created by AQIB JAVED on 12/1/2018.
 */

public class UserResponse {
    private int responseCode;
    private String responseStatus;
    private String responseDescription;
    private UserBean responseData;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public UserBean getResponseData() {
        return responseData;
    }

    public void setResponseData(UserBean responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "responseCode=" + responseCode +
                ", responseStatus='" + responseStatus + '\'' +
                ", responseDescription='" + responseDescription + '\'' +
                ", responseData=" + responseData +
                '}';
    }
}
