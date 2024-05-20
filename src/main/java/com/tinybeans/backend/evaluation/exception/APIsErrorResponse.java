package com.tinybeans.backend.evaluation.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * A class representing an API error response with a status code, message, and list of errors.
 * @author Anna Mack
 */

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class APIsErrorResponse implements Serializable {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    /**
     * Constructs a new API error response with the given status code, message, and error.
     * @param status the HTTP status code of the error response
     * @param message the message of the error response
     * @param error the error associated with the error response
     */
    public APIsErrorResponse(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Collections.singletonList(error);
    }


    /**
     * Sets the list of errors associated with the error response.
     * @param errors the list of errors to set
     */
    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }


    /**
     * Sets a single error associated with the error response.
     * @param error the error to set
     */
    public void setError(final String error) {
        errors = Collections.singletonList(error);
    }
}
