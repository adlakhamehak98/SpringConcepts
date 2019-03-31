package com.thymeleaf.thymeleafDemo.entity;

import java.util.Arrays;
import java.util.List;

public enum UserType {
    USER("has user role"),
    ADMIN("has admin role"),
    SUPER_ADMIN("has super_admin role");

    String message;

    UserType(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

//    public static List<UserType> getValues(){
//        return Arrays.asList(USER,ADMIN,SUPER_ADMIN);
//    }
}
