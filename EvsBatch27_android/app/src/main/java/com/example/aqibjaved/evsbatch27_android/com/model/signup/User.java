package com.example.aqibjaved.evsbatch27_android.com.model.signup;

/**
 * Created by AQIB JAVED on 3/4/2018.
 */

public class User {
    private String email;
    private String name;
    private String password;
    private String confirmPassword;
    private String contactNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isEmpty() {
        return this.getName().isEmpty() || this.getPassword().isEmpty() || this.getConfirmPassword().isEmpty() || this.getEmail().isEmpty();
    }
}
