package com.flipkart.exception;

public class InvalidAadharCardException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid Aadhar Card. Please enter correct aadhar card";
    }
}