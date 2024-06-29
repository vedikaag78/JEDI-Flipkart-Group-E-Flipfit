package com.flipkart.exception;

public class RegistrationFailedException extends Exception{
    @Override
    public String getMessage(){
        return "Registration Failed. Please try again";
    }
}