package br.com.emerion.exception;

import org.springframework.http.HttpStatus;

import br.com.emerion.enums.EnumException;

/**
 * Validation exceptions. Exceptions related to server-side verifications (i.e. user not found (404 - NOT_FOUND), etc).
 */
public class ValidationException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5247078057841333797L;
	
	private final HttpStatus httpStatus;
    private final String description;

    public ValidationException(EnumException exceptionEnum) {
        this.description = exceptionEnum.getDescription();
        this.httpStatus = exceptionEnum.getHttpStatus();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDescription() {
        return description;
    }
}
