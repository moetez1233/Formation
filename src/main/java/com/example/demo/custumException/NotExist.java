package com.example.demo.custumException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotExist extends RuntimeException {
    public NotExist(String message){
        super(message);
    }
}
