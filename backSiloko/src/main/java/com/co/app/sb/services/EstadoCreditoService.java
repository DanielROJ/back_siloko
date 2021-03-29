package com.co.app.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.model.EstadoCredito;
import com.co.app.sb.repository.EstadoCreditoRepository;

@Service
public class EstadoCreditoService {
	
	@Autowired
	private EstadoCreditoRepository estadoCreditoRep;
	
	
	public boolean getExistEstadoCredito(long idEstadoCredito) throws Exception {
		return this.estadoCreditoRep.existsById(idEstadoCredito);
	}
	
	
	public EstadoCredito getEstadoCredito(long idEstadoCredito) throws Exception{
		return this.estadoCreditoRep.findById(idEstadoCredito).orElseThrow();
	}

}
