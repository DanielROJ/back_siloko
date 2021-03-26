package com.co.app.sb.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.EstratoEconomicoDto;
import com.co.app.sb.Mappers.EstratoEconomicoMapper;
import com.co.app.sb.repository.EstratoEconomicoRepository;

@Service
public class EstratoEconomicoService {

	@Autowired
	private EstratoEconomicoRepository estratoRep;
	
	@Autowired
	private EstratoEconomicoMapper estratoMapper;
	
	
	public  List<EstratoEconomicoDto> getListEstratoEconomico() throws Exception{
		return this.estratoMapper.entityListToDtoList(this.estratoRep.findAll());
	}
	
	
	
	public EstratoEconomicoDto updatePuntajeEstrato(long idEstrato, int puntaje) throws Exception{
		if(this.estratoRep.existsById(idEstrato)) {
			this.estratoRep.ActualizarPuntaje(puntaje, idEstrato);
			return this.estratoMapper.toDto(this.estratoRep.findById(idEstrato).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
	
	
	
	
	
	
	
}
