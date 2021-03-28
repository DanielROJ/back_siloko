package com.co.app.sb.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.app.sb.DTOs.PaisDto;
import com.co.app.sb.Mappers.PaisMapper;
import com.co.app.sb.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository  paisRep;
	
	@Autowired
	private PaisMapper paisMapper;
	
	/**
	 * Meotodo que busca toos los paises de almacenados en la base de datos
	 * @return
	 * @throws Exception
	 */
	public List<PaisDto> getListPais() throws Exception{	
		return this.paisMapper.entityListToDtoList(this.paisRep.findAll());
	}
	
	
	public PaisDto updatePuntajePais(long idPais, int puntaje) throws Exception{
		if(this.paisRep.existsById(idPais)) {
			this.paisRep.ActualizarPuntaje(puntaje, idPais);
			return this.paisMapper.toDto(this.paisRep.findById(idPais).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
	
	
	public PaisDto updateValorPunto(long idPais, BigDecimal puntaje) throws Exception{
		if(this.paisRep.existsById(idPais)) {
			this.paisRep.ActualizarValorPunto(puntaje, idPais);
			return this.paisMapper.toDto(this.paisRep.findById(idPais).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
	
	

}
