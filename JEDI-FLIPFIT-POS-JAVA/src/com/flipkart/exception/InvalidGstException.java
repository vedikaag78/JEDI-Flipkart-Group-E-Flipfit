package com.flipkart.exception;

public class InvalidGstException extends Exception{
    @Override
    public String getMessage(){
    return "Invalid GST Id. Please enter correct id";
    }
}