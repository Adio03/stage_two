package com.example.zuri_stage_two.exceptions;
public class EmailNotFoundException extends RuntimeException{
    public EmailNotFoundException(String message){
        super(message);
    }
}
