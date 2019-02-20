package com.bootcamp.GCave.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppException  extends RuntimeException implements Serializable {

    /*public AppException()*/

    public AppException(String message){
        super(message);


    }


}
