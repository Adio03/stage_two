package com.example.zuri_stage_two.exceptions;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String message){
        super(message);
    }
    public EmailAlreadyExistException(Throwable cause){
        super(cause);
    }
}
