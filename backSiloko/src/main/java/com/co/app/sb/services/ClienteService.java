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
	
	
	
	public List<ClienteDto> getListClientes() throws Exception{
		return this.clienteMapper.entityListToDtoList(this.clienteRep.findAll());
	}
	
	
	public ClienteDto getClienteByDocumento(long cedula) throws Exception {
		Cliente cliente = this.clienteRep.findBydocumentoId(cedula).orElseThrow();
		return this.clienteMapper.toDto(cliente);
	}
	
	
	
}
