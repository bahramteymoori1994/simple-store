package com.example.store.store.exceptions;

public class ServiceException extends Exception
{
    private String message;

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public ServiceException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public ServiceException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}