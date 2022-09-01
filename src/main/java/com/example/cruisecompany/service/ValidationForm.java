package com.example.cruisecompany.service;

import com.example.cruisecompany.entity.User;

import java.util.regex.Pattern;

public class ValidationForm {

    public static boolean validate(User user){

        boolean valid = true;

        if(user == null || user.getEmail() == null || user.getPhoneNumber() == null || user.getPassword() == null
                || user.getName() == null || user.getSurname() == null){
            valid = false;
        }

        if(!Pattern.matches("(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))", user.getEmail())){
            valid = false;

        }

        if(!Pattern.matches("[0-9a-zA-Z!@#$%^&*]{6,}",user.getPassword())) {
            valid = false;
        }

        if(!Pattern.matches("(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?",user.getPhoneNumber())){
            valid = false;
        }

        return valid;

    }
}
