package com.evs.testapplication.sastabotique_local.evsandroid36.dto;

/**
 * Created by AQIB JAVED on 1/26/2019.
 */

public class Response {
    private int response_code;
    private String message;
    private UserDto userDto;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
