package com.co.app.sb.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.FuncionarioDto;
import com.co.app.sb.services.LoginService;

@RestController()
@RequestMapping(path = "/api/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	private Logger log = Logger.getLogger(LoginController.class.getName());
	
	
	@PostMapping("/funcionario")
	public ResponseEntity<FuncionarioDto> authFuncionario(){
		try {
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			return ResponseEntity.status(503).build();	
		}
	}
	
}
