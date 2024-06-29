package com.flipkart.exception;

public class SlotsUnavailableException extends Exception{
    @Override
    public String getMessage(){
        return "Slots unavailable. Please try another gym or different slot in the gym";
    }
}