package com.co.app.sb.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.CiudadDto;
import com.co.app.sb.DTOs.PaisDto;
import com.co.app.sb.services.PaisService;

@RestController()
@RequestMapping(path = "/api/pais", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	private Logger log = Logger.getLogger(CiudadController.class.getName());
	
	
	
	/**
	 * Metodo que permite buscar todos los paises de la base datos 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/list")
	public ResponseEntity<List<PaisDto>> getListPais() throws Exception{
		return  ResponseEntity.ok(this.paisService.getListPais());
	}
	
	
	@PutMapping("/puntaje")
	public ResponseEntity<PaisDto> setUpdatePuntaje(@RequestBody PaisDto paisDto) throws Exception{
		return ResponseEntity.ok(this.paisService.updatePuntajePais(paisDto.getId(), paisDto.getPointAmount()));
	}

}
