package com.maen.app.exceptions;

public class RequestCreatedCustomerException extends RuntimeException{
    public RequestCreatedCustomerException(String message) {
        super(message);
    }
}