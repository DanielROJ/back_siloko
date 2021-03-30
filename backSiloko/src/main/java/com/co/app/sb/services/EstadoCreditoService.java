package com.co.app.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.EstadoCreditoDto;
import com.co.app.sb.Mappers.EstadoCreditoMapper;
import com.co.app.sb.model.EstadoCredito;
import com.co.app.sb.repository.EstadoCreditoRepository;

@Service
public class EstadoCreditoService {
	
	@Autowired
	private EstadoCreditoRepository estadoCreditoRep;
	
	
	@Autowired
	private EstadoCreditoMapper estadoMapper;
	
	public boolean getExistEstadoCredito(long idEstadoCredito) throws Exception {
		return this.estadoCreditoRep.existsById(idEstadoCredito);
	}
	
	
	public EstadoCreditoDto getEstadoCredito(long idEstadoCredito) throws Exception{
		EstadoCredito estado = this.estadoCreditoRep.findById(idEstadoCredito).orElseThrow();
		return this.estadoMapper.toDto(estado);
	}

}
