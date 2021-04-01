package com.co.app.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.ClienteDto;
import com.co.app.sb.Mappers.ClienteMapper;
import com.co.app.sb.model.Cliente;
import com.co.app.sb.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRep;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	
	/**
	 * Metodo encargado de traer todos los clientes de la base de datos !!Cuidad!!
	 * @return List<ClienteDto>
	 * @throws Exception
	 */
	public List<ClienteDto> getListClientes() throws Exception{
		return this.clienteMapper.entityListToDtoList(this.clienteRep.findAll());
	}
	
	
	/**
	 * Metodo que pemrite encontrar un cliente por documento de identificacion
	 * @param cedula
	 * @return
	 * @throws Exception
	 */
	public ClienteDto getClienteByDocumento(long cedula) throws Exception {
		Cliente cliente = this.clienteRep.findBydocumentoId(cedula).orElseThrow();
		return this.clienteMapper.toDto(cliente);
	}
	
	
	/**
	 * Metodo encargado de verificar, que un cliente exista basado en si id en base de datos
	 * @param idCliente
	 * @return boolean
	 * @throws Exception
	 */
	public boolean getExistClient(long idCliente) throws Exception {
		return this.clienteRep.existsById(idCliente);
	}
	
	/**
	 * Metodo encargado de traer un cliente basado en su id de base de datos
	 * @param idCliente
	 * @return ClienteDto
	 * @throws Exception
	 */
	public ClienteDto getClienteById(long idCliente) throws Exception{
		Cliente cliente = this.clienteRep.findById(idCliente).orElseThrow();
		return this.clienteMapper.toDto(cliente);
	}
	
	
	
}
