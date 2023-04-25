package com.erfan.springrest.exception;

public class IllegalAgeException extends RuntimeException{
    public IllegalAgeException(String message){
        super(message);
    }
    public IllegalAgeException(String message , Throwable throwable){
        super(message,throwable);
    }
}