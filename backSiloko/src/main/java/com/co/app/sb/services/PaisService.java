package com.co.app.sb.services;

import java.util.List;

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
	
	

}
