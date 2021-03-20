package com.rayllanderson.model.dao;

public class DbException extends RuntimeException{

    public DbException (String msg){
        super(msg);
    }
}
