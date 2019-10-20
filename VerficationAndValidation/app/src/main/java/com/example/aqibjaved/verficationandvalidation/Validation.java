package com.example.aqibjaved.verficationandvalidation;

/**
 * Created by AQIB JAVED on 11/5/2017.
 */

public class Validation {
    private String username;
    private String password;
    public Validation(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean validatePassword(){
        boolean isContainNumber = false;
        boolean isContainSpecialChar = false;
        if(this.password != null && this.password.length() > 0){
            char [] passArray= this.password.toCharArray();
            for(char c: passArray){
                if(Character.isDigit(c)){
                    isContainNumber = true;
                }else if(!Character.isDigit(c) && !Character.isLetter(c) && !Character.isSpaceChar(c)){
                    isContainSpecialChar = true;
                }

            }
        }
        return (isContainNumber && isContainSpecialChar);
    }
    public boolean validateName(){
        boolean isValid = true;
        boolean isFirstLetterUperCase = true;
        if(this.username != null && this.username.length() > 0){
            char userNameArr[] = username.toCharArray();
            for(int x=0;x < userNameArr.length ; x++){
                if(x==0){
                    if(Character.isLetter(userNameArr[x])) {
                        if (!Character.isUpperCase(userNameArr[x])) {
                            isFirstLetterUperCase = false;
                            break;
                        }
                    }else{
                        isFirstLetterUperCase = false;
                        break;
                    }
                }else{
                    if(!Character.isDigit(userNameArr[x]) && !Character.isLetter(userNameArr[x]) && !Character.isSpaceChar(userNameArr[x])){
                        isValid = false;
                        break;
                    }
                }

            }
        }
        return (isValid && isFirstLetterUperCase);
    }
}
