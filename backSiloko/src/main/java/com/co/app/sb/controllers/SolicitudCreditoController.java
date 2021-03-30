package com.co.app.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.SolicitudCreditoDto;
import com.co.app.sb.services.SolicitudCreditoService;

@RestController()
@RequestMapping(path = "/api/solicitudCredito", produces = MediaType.APPLICATION_JSON_VALUE)
public class SolicitudCreditoController {
	
	
	@Autowired
	private SolicitudCreditoService solicitudService;
	
	
	
	@PostMapping("/generar")
	public ResponseEntity<SolicitudCreditoDto> setGenerarSolicitud(@RequestBody SolicitudCreditoDto solicitud) throws Exception{
		SolicitudCreditoDto solicitudDto = this.solicitudService.GenerarSolicitudCredito(solicitud);
		return ResponseEntity.ok(solicitudDto);
	}
	
	@GetMapping("/codigoF")
	public ResponseEntity<SolicitudCreditoDto> getSolicitudByCodeAndDocCliente(@RequestParam("codigo") String code, @RequestParam("documento") long documento) throws Exception{
		SolicitudCreditoDto solicitudDto= this.solicitudService.getSolicitudByCodeAndIdCliente(code, documento);
		return ResponseEntity.ok(solicitudDto);
	}
	

}
