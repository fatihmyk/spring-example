package com.fatihmayuk.exchandling.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String param){
        super(param);
    }

}
