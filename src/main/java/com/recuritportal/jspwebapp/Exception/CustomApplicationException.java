package com.recuritportal.jspwebapp.Exception;

public class CustomApplicationException extends RuntimeException {
    public CustomApplicationException(String message) {
        super(message);
    }

    public CustomApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
