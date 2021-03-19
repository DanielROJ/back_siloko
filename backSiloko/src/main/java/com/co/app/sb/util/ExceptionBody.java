package com.co.app.sb.util;


/**
 * Clase que permite darle un cuerpo estandar a los mensajes de error
 */
public class ExceptionBody {
	
	private int status;
	
	private String message;

	public ExceptionBody(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
