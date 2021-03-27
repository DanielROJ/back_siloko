package com.co.app.sb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.EstratoEconomicoDto;
import com.co.app.sb.services.EstratoEconomicoService;

@RestController()
@RequestMapping(path = "/api/estrato", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstratoEconomicoController {
	
	
	@Autowired
	private EstratoEconomicoService estratoService;
	
	
	@GetMapping("/list")
	public ResponseEntity<List<EstratoEconomicoDto>> getListEstratoEconomico() throws Exception{
		return ResponseEntity.ok(this.estratoService.getListEstratoEconomico());
	}
	
	
	@PutMapping("/puntaje")
	public ResponseEntity<EstratoEconomicoDto> setUpdatePuntaje(@RequestBody EstratoEconomicoDto estrato) throws Exception{
		return ResponseEntity.ok(this.estratoService.updatePuntajeEstrato(estrato.getId(), estrato.getAmountPoints()));
	}
	
	
	
	@GetMapping("")
	public ResponseEntity<EstratoEconomicoDto> getEstratoById(@RequestParam("value") int id)throws Exception{
		return ResponseEntity.ok(this.estratoService.getEstratoEconomicoByID(id));
	}

}
 