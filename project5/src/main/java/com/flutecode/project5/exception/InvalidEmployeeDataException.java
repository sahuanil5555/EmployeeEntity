package com.flutecode.project5.exception;

public class InvalidEmployeeDataException extends RuntimeException{
    public InvalidEmployeeDataException(String msg){
        super(msg);
    }
    public InvalidEmployeeDataException(String msg,Throwable cause){
        super(msg,cause);
    }
}
