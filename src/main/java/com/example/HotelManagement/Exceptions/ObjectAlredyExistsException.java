package com.example.HotelManagement.Exceptions;

public class ObjectAlredyExistsException extends RuntimeException {
    public ObjectAlredyExistsException(String message) {
        super(message);
    }
}
