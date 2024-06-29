package com.flipkart.exception;

public class SlotInsertionFailedException extends Exception{
    @Override
    public String getMessage(){
        return "Slot Insertion Failed";
    }
}