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
import com.co.app.sb.DTOs.ProductoTelefoniaDto;
import com.co.app.sb.services.ProductoTelefoniaService;

@RestController()
@RequestMapping(path = "/api/planTelefonia", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductoTelefoniaController {

	
	@Autowired
	private ProductoTelefoniaService productoService;
	
	
	
	/**
	 * Metodo que permite buscar todos los productos de telefonia en la base datos 
	 * @return List<ProductoTelefoniaDto>
	 * @throws Exception
	 */
	@GetMapping("/list")
	public ResponseEntity<List<ProductoTelefoniaDto>> getListProductosTelefonia() throws Exception{
		return ResponseEntity.ok(this.productoService.getListProductosTelefonia());
	}
	
	
	/**
	 * Metodo que actualiza el puntaje de  algun producto de telefonia seleccionado
	 * @param producto ProductoTelefoniaDto
	 * @return ProductoTelefoniaDto
	 * @throws Exception
	 */
	@PutMapping("/puntaje")
	public ResponseEntity<ProductoTelefoniaDto> setUpdatePuntaje(@RequestBody ProductoTelefoniaDto producto) throws Exception{
		return ResponseEntity.ok(this.productoService.updatePuntajeProductoTelfonia(producto.getId(), producto.getAmountPoints()));
	}
	
	
	
	
}
