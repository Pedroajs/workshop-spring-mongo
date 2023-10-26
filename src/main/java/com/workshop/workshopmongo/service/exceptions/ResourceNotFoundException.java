package com.workshop.workshopmongo.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found for Id: " + id);
    }

}