package com.workshop.workshopmongo.service.exceptions;

public class RollbackException extends RuntimeException {
    public RollbackException(String message) {
        super("Transaction need to be rolled back for any reason.");
    }
}