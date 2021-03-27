package com.co.app.sb.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.EstratoEconomicoDto;
import com.co.app.sb.Mappers.EstratoEconomicoMapper;
import com.co.app.sb.controllers.LoginController;
import com.co.app.sb.repository.EstratoEconomicoRepository;

@Service
public class EstratoEconomicoService {

	@Autowired
	private EstratoEconomicoRepository estratoRep;
	
	@Autowired
	private EstratoEconomicoMapper estratoMapper;
	
	private Logger log = Logger.getLogger(EstratoEconomicoService.class.getName());
	
	
	public  List<EstratoEconomicoDto> getListEstratoEconomico() throws Exception{
		return this.estratoMapper.entityListToDtoList(this.estratoRep.findAll());
	}
	
	
	
	public EstratoEconomicoDto updatePuntajeEstrato(int idEstrato, int puntaje) throws Exception{
		
		if(this.estratoRep.existsById(idEstrato)) {
			this.estratoRep.ActualizarPuntaje(puntaje, idEstrato);
			return this.estratoMapper.toDto(this.estratoRep.findById(idEstrato).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
	
	
	
	public EstratoEconomicoDto getEstratoEconomicoByID(int idEstrato) throws Exception {
		return  this.estratoMapper.toDto(this.estratoRep.findById(idEstrato).orElseThrow());
	}
	
	
	
	
	
}
