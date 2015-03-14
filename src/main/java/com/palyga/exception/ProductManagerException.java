package com.palyga.exception;

/**
 * Created by Admin on 13.03.2015.
 */
public class ProductManagerException  extends Exception {

    public ProductManagerException() {
    }

    public ProductManagerException(String message) {
        super(message);
    }

    public ProductManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
