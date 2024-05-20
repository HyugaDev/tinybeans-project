package com.tinybeans.backend.evaluation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * An exception that indicates that the client's request was invalid or malformed and cannot be processed by the server.
 * This exception should be thrown when the server receives a request that is syntactically incorrect, contains invalid parameters or data, or is otherwise unusable.
 * It should be returned to the client with an HTTP status code of 400 Bad Request.
 * This exception extends the RuntimeException class, which means that it is an unchecked exception and does not need to be declared in the method signature.
 * @see RuntimeException
 * @see HttpStatus #BAD_REQUEST
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
