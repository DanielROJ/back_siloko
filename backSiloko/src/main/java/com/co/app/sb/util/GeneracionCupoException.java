package com.co.app.sb.util;

public class GeneracionCupoException extends RuntimeException {

	private static final long serialVersionUID = 4L;

	
	public GeneracionCupoException() {
		super("No se pudo generar el cupo de credito para el cliente");
	}
}
