package com.rayllanderson.model.utils;

public class Generate {

    private static Long id = 0L;

    public static Long id (){
        return id++;
    }
}
