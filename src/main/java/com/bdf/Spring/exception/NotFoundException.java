package com.bdf.Spring.exception;

public class NotFoundException extends RuntimeException{
   public NotFoundException(String message) {
        super(message);
    }
}
