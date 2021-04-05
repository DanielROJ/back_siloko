package com.co.app.sb.services;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.ClienteDto;
import com.co.app.sb.DTOs.FuncionarioAlmacenDto;
import com.co.app.sb.DTOs.FuncionarioDto;
import com.co.app.sb.util.LoginException;




@Service
public class LoginService {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioAlmacenService funcionarioAlmacenService;
	
	
	@Autowired
	private ClienteService clienteService;
	
	
	
	private Logger log = Logger.getLogger(LoginService.class.getName());
	

	public FuncionarioDto authFuncionario(String correo, long codigoEmpleado) throws Exception{
		String correoRes = this.funcionarioService.getCorreoFuncionario(codigoEmpleado);
		
		if(correoRes.equals(null) || !correoRes.equals(correo))  {
			correoRes = null;
			throw new LoginException();		
		}else {
			correoRes = null;
			return this.funcionarioService.getFuncionarioByCodigoEmpleado(codigoEmpleado);
		}	
	}
	
	
	public FuncionarioAlmacenDto authFuncionarioAlmacen(String correo, long codigoEmpleado) throws Exception{
		String correoRes = this.funcionarioAlmacenService.getCorreoFuncionarioAlmacen(codigoEmpleado);
		
		if(correoRes.equals(null) || !correoRes.equals(correo))  {
			correoRes = null;
			throw new LoginException();		
		}else {
			correoRes = null;
			return this.funcionarioAlmacenService.getFuncionarioByCodigo(codigoEmpleado);
		}	
	}
	
	
	public ClienteDto authCliente(String correo, long documento) throws Exception{
		String correoRes = this.clienteService.getCorreoCliente(documento);	
		if(correoRes.equals(null) || !correoRes.equals(correo))  {
			correoRes = null;
			throw new LoginException();		
		}else {
			correoRes = null;
			return this.clienteService.getClienteByDocumento(documento);
		}	
	}
	
	
	

}
