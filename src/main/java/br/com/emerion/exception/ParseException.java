package br.com.emerion.exception;

public class ParseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2366333288376113923L;

	public ParseException() {
		super();
	}

	public ParseException(String message) {
		super(message);
	}

	public ParseException(Throwable cause) {
		super(cause);
	}
}
