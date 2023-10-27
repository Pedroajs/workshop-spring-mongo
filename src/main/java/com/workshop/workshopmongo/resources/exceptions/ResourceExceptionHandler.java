package com.workshop.workshopmongo.resources.exceptions;

import com.workshop.workshopmongo.service.exceptions.ResourceNotFoundException;
import com.workshop.workshopmongo.service.exceptions.RollbackException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<OwnedError> resourceNotFound(
            ResourceNotFoundException exception,
            HttpServletRequest request
    ){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        OwnedError ownedError = new OwnedError(
                Instant.now(),
                status.value(),
                error,
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(ownedError);
    }

    @ExceptionHandler
    public ResponseEntity<OwnedError> rollbacked(
            RollbackException exception,
            HttpServletRequest request
    ){
        String error = "Transaction failed";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        OwnedError ownedError = new OwnedError(
                Instant.now(),
                status.value(),
                error,
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(ownedError);
    }
}
