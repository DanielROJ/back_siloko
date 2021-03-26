package com.co.app.sb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.app.sb.DTOs.RangoAntiguedadDto;
import com.co.app.sb.services.RangoAntiguedadService;

@RestController()
@RequestMapping(path = "/api/rangoAntiguedad", produces = MediaType.APPLICATION_JSON_VALUE)
public class RangoAntiguedadController {
	
	@Autowired
	private RangoAntiguedadService rangoService;
	

	/**
	 * Metodo que permite buscar todos los rangos de antiguedad de la base datos 
	 * @return List<RangoAntiguedadDto>
	 * @throws Exception
	 */
	@GetMapping("/list")
	public ResponseEntity<List<RangoAntiguedadDto>> getListRangoAntiguedad() throws Exception{
		return  ResponseEntity.ok(this.rangoService.getListRangoAntiguedad());
	}
	
	
	/**
	 * Metodo que actualiza el puntaje de credito de algun un rango seleccionado
	 * @param rangoDto
	 * @return ResponseEntity<RangoAntiguedadDto> 
	 * @throws Exception
	 */
	@PutMapping("/puntaje")
	public ResponseEntity<RangoAntiguedadDto> setUpdatePuntaje(@RequestBody RangoAntiguedadDto rangoDto) throws Exception{
		return ResponseEntity.ok(this.rangoService.updatePuntajeRangoAntiguedad(rangoDto.getId(), rangoDto.getAmountPoints()));
	}
	
	
	
}
