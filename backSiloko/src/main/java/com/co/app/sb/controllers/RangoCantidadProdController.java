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
import com.co.app.sb.DTOs.RangoCantidadProductosDto;
import com.co.app.sb.services.RangoCantidadService;

@RestController()
@RequestMapping(path = "/api/RangoCantidad", produces = MediaType.APPLICATION_JSON_VALUE)
public class RangoCantidadProdController {
	
	
	@Autowired
	private RangoCantidadService rangoService;
	
	
	/**
	 * Metodo que permite buscar todos los rangos de cantidad de productos en la base datos 
	 * @return List<RangoCantidadProductosDto>
	 * @throws Exception
	 */
	@GetMapping("/list")
	public ResponseEntity<List<RangoCantidadProductosDto>> getListRangoCantidadProductos() throws Exception{
		return  ResponseEntity.ok(this.rangoService.getListRangoCantidadProductos());
	}
	
	
	/**
	 * Metodo que actualiza el puntaje de credito de algun rango seleccionado
	 * @param rangoDto
	 * @return ResponseEntity<RangoCantidadProductosDto> 
	 * @throws Exception
	 */
	@PutMapping("/puntaje")
	public ResponseEntity<RangoCantidadProductosDto> setUpdatePuntaje(@RequestBody RangoCantidadProductosDto rangoDto) throws Exception{
		return ResponseEntity.ok(this.rangoService.updatePuntajeRangoCantidadProductos(rangoDto.getId(), rangoDto.getAmountPoints()));
	}
	
	

}
