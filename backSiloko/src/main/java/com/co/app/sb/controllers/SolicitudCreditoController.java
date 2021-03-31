package com.co.app.sb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/cliente/list")
	public ResponseEntity<List<SolicitudCreditoDto>> getListSolicitudesByIdCliente(@RequestParam("id")long idCliente, @RequestParam("nPage") int nPage, @RequestParam("nRows") int nRows) throws Exception{
		List<SolicitudCreditoDto> listSolDto = this.solicitudService.getListSolicitudesPageable(idCliente, nPage, nRows);
		long countLimit = this.solicitudService.getCountNumberRowsSolicitudCredito(idCliente);
		 HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.set("rows-limit", countLimit+"");
		return  ResponseEntity.ok().headers(responseHeaders).body(listSolDto);
	}
	
	
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
	
	
	@PutMapping("/financiar")
	public ResponseEntity<Boolean> InciarFinanciacionSolicitud(@RequestParam("solicitud")long idSolicitud,
			@RequestParam("funcionarioA")	long idFuncionarioAlm,@RequestParam("cuotas") int numeroCoutas) throws Exception{
		boolean res = false;
	res =  this.solicitudService.setIncioFinanciacionSolicitud(idSolicitud, idFuncionarioAlm, numeroCoutas);
		return ResponseEntity.ok(res);
	}
	
	
	
	
	/*
	@GetMapping("/list")
	public ResponseEntity<List<SolicitudCredito>> getListSolicitudCredito() throws Exception{
		List<SolicitudCredito> listSol =this.solicitudService.getListSolicitudes();
		return ResponseEntity.ok(listSol);
	}
	
	
	@GetMapping("")
	public ResponseEntity<SolicitudCredito> getSolicitudById(@RequestParam("value") long idSolicitud){
		if(this.solicitudService.existSolicitud()) {
			SolicitudCredito sol  =  this.solicitudService.getSolicitudCredito(idSolicitud);
			return ResponseEntity.ok(sol);
		}else {
			
			return ResponseEntity.ok(null);
		}
		
	}
	*/

}
