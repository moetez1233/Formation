package com.example.demo.CustumException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleException(NotExist exception){
        ErrorObject errorObject=new ErrorObject(HttpStatus.NOT_FOUND.value(),exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handlerValidationException(MethodArgumentNotValidException exception){
        ErrorObject errorObject=new ErrorObject(HttpStatus.BAD_REQUEST.value(),exception.getFieldError().getDefaultMessage(),System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.BAD_REQUEST);
    }
}
