package com.example.HotelManagement.Exceptions;

public class ObjectNotExistsException extends RuntimeException {
    public ObjectNotExistsException(String message) {
        super(message);
    }
}
