package br.com.emerion.exception;

public class MethodNotImplemented extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2366333288376113923L;

	public MethodNotImplemented() {
		super();
	}

	public MethodNotImplemented(String message) {
		super(message);
	}

	public MethodNotImplemented(Throwable cause) {
		super(cause);
	}
}
