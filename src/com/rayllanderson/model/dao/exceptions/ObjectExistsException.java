package com.rayllanderson.model.dao.exceptions;

public class ObjectExistsException extends RuntimeException {

    public ObjectExistsException(String msg) {
        super(msg);
    }
}
