package com.rayllanderson.model.dao.exceptions;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(String msg) {
        super(msg);
    }
}
