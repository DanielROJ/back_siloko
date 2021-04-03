package com.co.app.sb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.ReciboDto;
import com.co.app.sb.services.ReciboService;

@RestController()
@RequestMapping(path = "/api/recibo", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReciboController {
	
	@Autowired
	private ReciboService reciboService;
	
	
	@GetMapping("cliente/list")
	public ResponseEntity<List<ReciboDto>> getListRecibosByIdCliente(@RequestParam("id")long idCliente, @RequestParam("nPage") int nPage, @RequestParam("nRows") int nRows) throws Exception{
		List<ReciboDto> listReciboDto =  this.reciboService.getListRecibosByIdCliente(idCliente, nPage, nRows);
		HttpHeaders responseHeaders = new HttpHeaders();
		long countLimit = this.reciboService.getCountNumberRowsRecibosCliente(idCliente);
	    responseHeaders.set("rows-limit", countLimit+"");
	    return  ResponseEntity.ok().headers(responseHeaders).body(listReciboDto);
	}
	
	
	@PostMapping("/masivo")
	public ResponseEntity<Boolean> ExecuteProcesoMasivo() throws Exception{
		boolean res = this.reciboService.ExecuteProcesoMasivo();
		return ResponseEntity.ok(res);
	}

}
