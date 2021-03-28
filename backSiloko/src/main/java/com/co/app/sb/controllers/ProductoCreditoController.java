package com.co.app.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.ProductoCreditoDto;
import com.co.app.sb.services.ProductoCreditoService;

@RestController()
@RequestMapping(path = "/api/productoCredito", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductoCreditoController {
	
	@Autowired
	private ProductoCreditoService productoService;
	
	
	
	@GetMapping("/codigoSiloko")
	public ResponseEntity<ProductoCreditoDto> getProductoCreditoBSilokoCode(@RequestParam("value") String codigo) throws Exception{
		ProductoCreditoDto producto = this.productoService.getProductoCreditoBySilkoCode(codigo);
		return ResponseEntity.ok(producto);
	}

}
