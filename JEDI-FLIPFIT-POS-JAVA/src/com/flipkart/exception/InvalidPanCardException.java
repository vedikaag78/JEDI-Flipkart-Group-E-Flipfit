package com.flipkart.exception;

public class InvalidPanCardException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid Pan Card details. Please enter correct Pan Card details";
    }
}