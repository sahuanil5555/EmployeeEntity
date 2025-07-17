package com.flutecode.project5.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String msg){
        super(msg);
    }
    public EmployeeAlreadyExistsException(String msg,Throwable cause){
        super(msg,cause);
    }
}
