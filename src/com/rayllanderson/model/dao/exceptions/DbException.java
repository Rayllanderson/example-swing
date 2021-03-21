package com.rayllanderson.model.dao.exceptions;

public class DbException extends RuntimeException{

    public DbException (String msg){
        super(msg);
    }
}
