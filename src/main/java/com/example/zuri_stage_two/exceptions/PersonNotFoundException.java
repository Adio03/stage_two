package com.example.zuri_stage_two.exceptions;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(){
    }
    public PersonNotFoundException(String message){
        super(message);
    }
    public PersonNotFoundException(Throwable cause){
        super(cause);
    }
}
