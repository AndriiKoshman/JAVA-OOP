package com.company;

public class MyException extends Exception {
    @Override
    public String getMessage(){
        return "ERROR: Student out of place";
    }
}
