package com.co.app.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.model.CupoCredito;
import com.co.app.sb.model.EstadoCupo;
import com.co.app.sb.repository.CupoCreditoRepository;
import com.co.app.sb.repository.EstadoCupoRepository;

@Service
public class CupoCreditoService {
	
	@Autowired
	private CupoCreditoRepository cupoCreditoRe;
	
	@Autowired
	private EstadoCupoRepository estadoCupoRep;
	
	
	
	public boolean BloquearCupo(long idCliente) throws Exception {
		CupoCredito cupo = this.cupoCreditoRe.findByuser_idCliente(idCliente).orElseThrow();
		EstadoCupo  estadoCupo = this.estadoCupoRep.findByestado("Bloqueado").orElseThrow();
		cupo.setEstadoCupo(estadoCupo);
		this.cupoCreditoRe.save(cupo);
		this.cupoCreditoRe.flush();
		return true;
	}

}
