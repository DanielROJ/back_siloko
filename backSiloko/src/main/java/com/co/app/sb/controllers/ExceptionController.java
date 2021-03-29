package com.co.app.sb.controllers;


import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;
import com.co.app.sb.util.ExceptionBody;
import com.co.app.sb.util.GeneracionCupoException;
import com.co.app.sb.util.LoginException;
import com.co.app.sb.util.SolicitudCreditoException;

/**
 * Clase controlador que permite gestionar los errores que se presenten en el procesamiento de las peticiones rest
 * 
 * @author German Daniel Rojas
 *
 */

@ControllerAdvice
public class ExceptionController {
	
	
	private ExceptionBody bodyEx;
	
	private String message;
	
	private Logger log = Logger.getLogger(ExceptionController.class.getName());
	
	
	@ExceptionHandler({ NoSuchElementException.class, ClassCastException.class, LoginException.class, GeneracionCupoException.class,
		SolicitudCreditoException.class})
	public final ResponseEntity<ExceptionBody> handleException(Exception ex, WebRequest request) {
		
		HttpHeaders headers = new HttpHeaders();
		log.warning("Handling " + ex.getClass().getSimpleName() + " due to " + ex.getMessage());
			
		if(ex  instanceof SolicitudCreditoException ) {
			
		 	this.message = ex.getMessage();
			this.bodyEx = new ExceptionBody(404, this.message);			
		    return handleExceptionInternal(ex, this.bodyEx, headers, HttpStatus.NOT_FOUND, request);
			
		}else if(ex instanceof GeneracionCupoException ) {
			 	this.message = "No se pudo generar el cupo credito";
				this.bodyEx = new ExceptionBody(404, this.message);			
			    return handleExceptionInternal(ex, this.bodyEx, headers, HttpStatus.NOT_FOUND, request);
	
		 }else if(ex instanceof LoginException ) {
			 	this.message = "No se pudo iniciar sesion, resvisar datos de entrada";
				this.bodyEx = new ExceptionBody(401, this.message);			
			    return handleExceptionInternal(ex, this.bodyEx, headers, HttpStatus.UNAUTHORIZED, request);
			    
		 }else if( ex instanceof ClassCastException) {
			
			this.message = "Error de parametros body";
			this.bodyEx = new ExceptionBody(400, this.message);			
		    return handleExceptionInternal(ex, this.bodyEx, headers, HttpStatus.BAD_REQUEST, request);
		    
		    
		}else if (ex instanceof NoSuchElementException) {
			
			this.message = "No se encontro el elemento";
			this.bodyEx = new ExceptionBody(404, this.message);			
		    return handleExceptionInternal(ex, this.bodyEx, headers, HttpStatus.NOT_FOUND, request);

		} else  {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);
		}
	}


	
	
	
	
	
	
	

	/** A single place to customize the response body of all Exception types. */
	protected ResponseEntity<ExceptionBody> handleExceptionInternal(Exception ex, ExceptionBody body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<>(body, headers, status);
	}
	
	
}
