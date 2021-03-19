package com.co.app.sb.util;

public class LoginException extends RuntimeException {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public LoginException() {
		
		super("Error al iniciar sesion");
	}
}
