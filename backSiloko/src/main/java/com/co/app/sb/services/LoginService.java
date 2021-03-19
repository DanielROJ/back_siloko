package com.co.app.sb.services;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.FuncionarioDto;
import com.co.app.sb.util.LoginException;




@Service
public class LoginService {

	@Autowired
	private FuncionarioService funcionarioService;
	
	
	private Logger log = Logger.getLogger(LoginService.class.getName());
	

	public FuncionarioDto authFuncionario(String correo, long codigoEmpleado) throws Exception{
		String correoFuncionario = this.funcionarioService.getCorreoFuncionario(codigoEmpleado);
		
		if(correoFuncionario.equals(null) || !correoFuncionario.equals(correo))  {
			correoFuncionario = null;
			throw new LoginException();		
		}else {
			correoFuncionario = null;
			return this.funcionarioService.getFuncionarioByCodigoEmpleado(codigoEmpleado);
		}	
	}
	
	
	

}
