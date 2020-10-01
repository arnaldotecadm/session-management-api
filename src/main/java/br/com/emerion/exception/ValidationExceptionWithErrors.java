package br.com.emerion.exception;

import br.com.emerion.enums.EnumException;

/**
 * Validation exceptions. Exceptions related to server-side verifications (i.e.
 * user already exists (409 - Conflict), etc).
 */
public class ValidationExceptionWithErrors extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3930829979254446762L;

	public ValidationExceptionWithErrors(EnumException exceptionEnum) {
		super(exceptionEnum);
	}
}
