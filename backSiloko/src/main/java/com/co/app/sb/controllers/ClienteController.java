package com.co.app.sb.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.co.app.sb.DTOs.ClienteDto;
import com.co.app.sb.DTOs.CupoCreditoDto;
import com.co.app.sb.services.ClienteService;
import com.co.app.sb.services.CupoCreditoService;

@RestController()
@RequestMapping(path = "/api/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CupoCreditoService cupoCreditoService;
	
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
	
	/**
	 * Metodo que bloquea el cupo de credito de un cliente, cuando un funcionario envia la orden
	 * @param idCliente id del cliente en la base de datos 
	 * @param idFuncionario id del funcionario  en la base de datos
	 * @return CupoCredito actualizado con el nuevo estado;
	 * @throws Exception
	 */
	@PostMapping("/cupoCredito/bloquear")
	public ResponseEntity<CupoCreditoDto> setBloquearCupoCredito(@RequestParam(value = "cliente") long idCliente, @RequestParam(value = "funcionario") long idFuncionario)throws Exception{
		CupoCreditoDto res = this.cupoCreditoService.BloquearCupo(idCliente, idFuncionario);
		return ResponseEntity.ok(res);
	}
	
	
	/**
	 * Metodo que desbloquea el cupo de credito de un cliente, cuando un funcionario envia la orden
	 * @param idCliente id del cliente en la base de datos 
	 * @param idFuncionario id del funcionario  en la base de datos
	 * @return CupoCredito actualizado con el nuevo estado;
	 * @throws Exception
	 */
	@PostMapping("/cupoCredito/desbloquear")
	public ResponseEntity<CupoCreditoDto> setDesbloquearCupoCredito(@RequestParam(value = "cliente") long idCliente, @RequestParam(value = "funcionario") long idFuncionario)throws Exception{
		CupoCreditoDto res = this.cupoCreditoService.DesbloquearCupo(idCliente, idFuncionario);
		return ResponseEntity.ok(res);
	}
	
	
	/**
	 * Metodo que genera el cupo de credito de un cliente, cuando un funcionario envia la orden
	 * @param idCliente id del cliente en la base de datos 
	 * @param idFuncionario id del funcionario  en la base de datos
	 * @return CupoCredito actualizado con el nuevo estado y valor asignado;
	 * @throws Exception
	 */
	@PostMapping("/cupoCredito/generar")
	public ResponseEntity<CupoCreditoDto> setGenerarCupoCredito(@RequestParam(value = "cliente") long idCliente, @RequestParam(value = "funcionario") long idFuncionario)throws Exception{
		CupoCreditoDto res = this.cupoCreditoService.GenerarCupoCliente(idCliente, idFuncionario);
		return ResponseEntity.ok(res);
	}
	
	
	/**
	 * Meotodo que permite asignar manualmente un cupo de credito a un usuario
	 * @param idFuncionario
	 * @param cupo
	 * @returnResponseEntity<CupoCreditoDto>
	 * @throws Exception
	 */
	@PutMapping("/cupoCredito/manual")
	public ResponseEntity<CupoCreditoDto> setSaldoCupoCredito(@RequestParam(value = "funcionario") long idFuncionario, @RequestBody CupoCreditoDto cupo)throws Exception{
		CupoCreditoDto res = this.cupoCreditoService.AsignarCupoCreditoManual(idFuncionario,  cupo.getId(), cupo.getTotalSizeCredit());
		return ResponseEntity.ok(res);
	}
	
	
	
	
	/*
	@GetMapping("/cupoCredito")
	public ResponseEntity<List<CupoCredito>> listCupo(){
		return ResponseEntity.ok(this.cupoCreditoService.listCupoCredito());
	}
	*/
	
	
	/**
	 * Metodo que busca un cliente por su id en base de datos
	 * @param idCliente
	 * @return
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<ClienteDto> getClienteByIdCliente(@RequestParam("value") long idCliente)throws Exception{
		ClienteDto clienteDto = this.clienteService.getClienteById(idCliente);
		return ResponseEntity.ok(clienteDto);
	}
	
	
	
	
	
}
