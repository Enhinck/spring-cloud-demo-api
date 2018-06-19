package com.enhinck.demo.api.auth;

public class AuthenticationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1512945793011553446L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
