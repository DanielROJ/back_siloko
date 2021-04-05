package com.co.app.sb.controllers;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.ClienteDto;
import com.co.app.sb.DTOs.FuncionarioAlmacenDto;
import com.co.app.sb.DTOs.FuncionarioDto;
import com.co.app.sb.services.LoginService;

/**
 * Clase que permite el control de peticiones HTTP de entrada y salida del
 * loogin siloko
 * 
 * @author German Daniel Rojas
 *
 */

@RestController()
@RequestMapping(path = "/api/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	@Autowired
	private LoginService loginService;

	private Logger log = Logger.getLogger(LoginController.class.getName());

	/**
	 * Metodo que recibe los datos de autenticacion del login Siloko
	 * 
	 * @param body JSON // code : codigo_empleado , email: correo empleado
	 * @return JSON
	 * @throws Exception LoginException()
	 */
	@PostMapping("/funcionario")
	public ResponseEntity<FuncionarioDto> authFuncionario(@RequestBody Map<String, Object> body) throws Exception {

		String correoFuncionario = (String) body.get("email");
		long codigoFuncionario = Long.valueOf((Integer) body.get("code"));

		FuncionarioDto res = this.loginService.authFuncionario(correoFuncionario, codigoFuncionario);
		return ResponseEntity.ok(res);

	}

	@PostMapping("/funcionarioAlmacen")
	public ResponseEntity<FuncionarioAlmacenDto> authFuncionarioAlm(@RequestBody Map<String, Object> body)
			throws Exception {

		String correoFuncionario = (String) body.get("email");
		long codigoFuncionario = Long.valueOf((Integer) body.get("code"));

		FuncionarioAlmacenDto res = this.loginService.authFuncionarioAlmacen(correoFuncionario, codigoFuncionario);
		return ResponseEntity.ok(res);

	}

	@PostMapping("/cliente")
	public ResponseEntity<ClienteDto> authCliente(@RequestBody Map<String, Object> body) throws Exception {

		String correo = (String) body.get("email");
		long clienteDocumento = Long.valueOf((Integer) body.get("code"));

		ClienteDto res = this.loginService.authCliente(correo, clienteDocumento);
		return ResponseEntity.ok(res);

	}

}
