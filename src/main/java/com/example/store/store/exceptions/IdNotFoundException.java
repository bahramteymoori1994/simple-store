package com.example.store.store.exceptions;

public class IdNotFoundException extends ServiceException
{
    public IdNotFoundException(String message) {
        super(message);
    }

    public IdNotFoundException(String message, String message1) {
        super(message, message1);
    }

    public IdNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause, message1);
    }

    public IdNotFoundException(Throwable cause, String message) {
        super(cause, message);
    }

    public IdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace, message1);
    }
}