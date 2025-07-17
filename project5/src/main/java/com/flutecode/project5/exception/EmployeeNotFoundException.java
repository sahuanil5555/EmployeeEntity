package com.flutecode.project5.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
    public EmployeeNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
}
