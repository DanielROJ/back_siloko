package com.co.app.sb.services;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.app.sb.DTOs.CiudadDto;
import com.co.app.sb.Mappers.CiudadMapper;
import com.co.app.sb.repository.CiudadRepository;
import java.util.logging.Logger;


@Service
public class CiudadService {

	
	@Autowired
	private CiudadRepository ciudadRep;
	
	@Autowired
	private CiudadMapper ciudadMapper;
	
	private Logger log = Logger.getLogger(CiudadService.class.getName());
	
	public List<CiudadDto> getAllCiudades() throws Exception {
		return this.ciudadMapper.entityListToDtoList(this.ciudadRep.findAll());
	}
	
	
	public List<CiudadDto> getAllCiudadesByPais(long idPais) throws Exception {
		return this.ciudadMapper.entityListToDtoList(this.ciudadRep.findBypais_idPais(idPais));
	}
	
	
	public CiudadDto updatePuntajeCiudad(long idCiudad, int puntaje) throws Exception{
		if(this.ciudadRep.existsById(idCiudad)) {
			this.ciudadRep.ActualizarPuntaje(puntaje, idCiudad);
			return this.ciudadMapper.toDto(this.ciudadRep.findById(idCiudad).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
}
