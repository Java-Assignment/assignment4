package com.abhi.assignment4.exception;

public class AppAccountNotFoundException extends Exception {
    public AppAccountNotFoundException(String errormsg) {
        super(errormsg);
    }
}
