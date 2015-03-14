package com.palyga.exception;

/**
 * Created by Admin on 13.03.2015.
 */
public class UsersManagerException extends RuntimeException {

    public UsersManagerException() {

    }

    public UsersManagerException(String message) {
        super(message);
    }

    public UsersManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
