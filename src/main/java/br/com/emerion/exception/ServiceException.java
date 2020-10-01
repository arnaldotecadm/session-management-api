package br.com.emerion.exception;

import org.springframework.http.HttpStatus;

import br.com.emerion.enums.EnumVersionException;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8222041349507934815L;

	private final ServiceExceptionDTO exceptionDTO;
	private final HttpStatus httpStatus;

	public ServiceException(EnumVersionException versionException) {
		super(versionException.getLabel());
		this.exceptionDTO = new ServiceExceptionDTO(versionException.getLabel());
		this.httpStatus = versionException.getHttpStatus();
	}

	public ServiceExceptionDTO getExceptionDTO() {
		return exceptionDTO;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
