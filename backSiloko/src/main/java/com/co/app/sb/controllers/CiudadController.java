package com.co.app.sb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.CiudadDto;
import com.co.app.sb.services.CiudadService;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController()
@RequestMapping(path = "/api/ciudad", produces = MediaType.APPLICATION_JSON_VALUE)
public class CiudadController {
	
	@Autowired
	private CiudadService ciudadServie;
	
	private Logger log = Logger.getLogger(CiudadController.class.getName());
	
	@GetMapping("/list")
	public ResponseEntity<List<CiudadDto>> getListCiudades(){
		try {
			return ResponseEntity.ok(this.ciudadServie.getAllCiudades());
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			return ResponseEntity.status(503).build();		
		}
	}
	
	
	@GetMapping("/pais")
	public ResponseEntity<List<CiudadDto>> getListCiudadesByPais(@RequestParam("value") long idPais) throws Exception{
		return ResponseEntity.ok(this.ciudadServie.getAllCiudadesByPais(idPais));
	}
	

}
