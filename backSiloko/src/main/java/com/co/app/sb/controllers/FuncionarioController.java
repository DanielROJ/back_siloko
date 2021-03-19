package com.co.app.sb.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.co.app.sb.DTOs.FuncionarioDto;
import com.co.app.sb.services.FuncionarioService;

@RestController()
@RequestMapping(path = "/api/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	private Logger log = Logger.getLogger(FuncionarioController.class.getName());

	@GetMapping("/list")
	public ResponseEntity<List<FuncionarioDto>> getListFuncionarios() throws Exception {
		return ResponseEntity.ok(this.funcionarioService.getListFuncionarios());
	}

	@GetMapping("")
	public ResponseEntity<FuncionarioDto> getFuncionario(
			@RequestParam(name = "value", required = true) long idFuncionario) {
		FuncionarioDto funcionario = this.funcionarioService.getFuncionario(idFuncionario);
		return ResponseEntity.ok(funcionario);
	}

}
