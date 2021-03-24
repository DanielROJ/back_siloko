package com.co.app.sb.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.sb.DTOs.CiudadDto;
import com.co.app.sb.DTOs.ClienteDto;
import com.co.app.sb.services.ClienteService;

@RestController()
@RequestMapping(path = "/api/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	private Logger log = Logger.getLogger(ClienteController.class.getName());
	
	
	/**
	 * Metodo que retorna todos los clientes de la base de datos, !!cuidado!!
	 * @return List<ClienteDto>
	 */
	@GetMapping("/list")
	public ResponseEntity<List<ClienteDto>> getListClientes(){
		try {
			
			return ResponseEntity.ok(this.clienteService.getListClientes());
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			return ResponseEntity.status(503).build();	
		}
	}
	
	
	/**
	 * Metodo que retorna un cliente basado en su documento de identificacion nacional
	 * @return ResponseEntity<ClienteDto>
	 */
	@GetMapping("/documentoId")
	public ResponseEntity<ClienteDto> getClienteByDocumento(@RequestParam(value = "value") long documento) throws Exception{
		return ResponseEntity.ok(this.clienteService.getClienteByDocumento(documento));
	}
	
	
}
