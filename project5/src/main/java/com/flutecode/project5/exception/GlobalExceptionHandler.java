package com.flutecode.project5.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
   ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body("Invalid input data: Please check your request and try again");
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException exception){
        return ResponseEntity.status(404).body("Employee not found");
    }
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    ResponseEntity<String> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException exception){
        return ResponseEntity.status(409).body("Employee already exists");
    }
    @ExceptionHandler(InvalidEmployeeDataException.class)
    ResponseEntity<String> handleInvalidEmployeeDataException(InvalidEmployeeDataException exception){
        return ResponseEntity.badRequest().body("Invalid employee data");
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleGenericException(Exception exception){
        return ResponseEntity.internalServerError().body("An Unexpected error occurred: please try again later");

    }
}
