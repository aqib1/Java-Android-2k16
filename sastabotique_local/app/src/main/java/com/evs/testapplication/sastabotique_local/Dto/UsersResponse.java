package com.evs.testapplication.sastabotique_local.Dto;

/**
 * Created by AQIB JAVED on 10/27/2018.
 */

public class UsersResponse {
    private int STATUS_CODE;
    private String STATUS_DESCRIPTION;
    private String CSRF_TOKEN;

    public int getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public void setSTATUS_CODE(int STATUS_CODE) {
        this.STATUS_CODE = STATUS_CODE;
    }

    public String getSTATUS_DESCRIPTION() {
        return STATUS_DESCRIPTION;
    }

    public void setSTATUS_DESCRIPTION(String STATUS_DESCRIPTION) {
        this.STATUS_DESCRIPTION = STATUS_DESCRIPTION;
    }

    public String getCSRF_TOKEN() {
        return CSRF_TOKEN;
    }

    public void setCSRF_TOKEN(String CSRF_TOKEN) {
        this.CSRF_TOKEN = CSRF_TOKEN;
    }
}
