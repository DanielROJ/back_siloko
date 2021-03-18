package com.co.app.sb.services;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LoginService {

	@Autowired
	private FuncionarioService funcionarioService;
	
	
	private Logger log = Logger.getLogger(LoginService.class.getName());
	

	private boolean authFuncionario(String correo, long codigoEmpleado) throws Exception{
		String correoFuncionario = this.funcionarioService.getCorreoFuncionario(codigoEmpleado);
		if(correoFuncionario.equals(null) || !correoFuncionario.equals(correo)) {
			correoFuncionario = null;
			log.info("ERR Inicio de sesion usr:"+codigoEmpleado+" email:"+correo);
			return false;
		}else {
			correoFuncionario = null;
			log.info("OK Inicio de sesion usr:"+codigoEmpleado+" email:"+correo);
			return true;
		}	
	}
	
	
	

}
