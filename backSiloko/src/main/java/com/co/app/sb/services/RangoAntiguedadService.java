package com.co.app.sb.services;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.app.sb.DTOs.RangoAntiguedadDto;
import com.co.app.sb.Mappers.RangoAntiguedadMapper;
import com.co.app.sb.repository.RangoAntiguedadRepository;

@Service
public class RangoAntiguedadService {
	
	@Autowired
	private RangoAntiguedadRepository rangoRep;
	
	@Autowired
	private RangoAntiguedadMapper rangoMapper;
	
	
	

	public  List<RangoAntiguedadDto> getListRangoAntiguedad() throws Exception{
		return this.rangoMapper.entityListToDtoList(this.rangoRep.findAll());
	}
	
	
	
	public RangoAntiguedadDto  updatePuntajeRangoAntiguedad(long idRangoAntiguedad, int puntaje) throws Exception{
		if(this.rangoRep.existsById(idRangoAntiguedad)) {
			this.rangoRep.ActualizarPuntaje(puntaje, idRangoAntiguedad);
			return this.rangoMapper.toDto(this.rangoRep.findById(idRangoAntiguedad).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
	

}
