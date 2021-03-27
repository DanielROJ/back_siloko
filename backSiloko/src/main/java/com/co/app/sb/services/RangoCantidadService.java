package com.co.app.sb.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.app.sb.DTOs.RangoCantidadProductosDto;
import com.co.app.sb.Mappers.RangoCantidadProductosMapper;
import com.co.app.sb.repository.RangoCantidadProductosRepository;

@Service
public class RangoCantidadService {
	
	@Autowired
	private RangoCantidadProductosRepository rangoCanRep;
	
	
	@Autowired
	private RangoCantidadProductosMapper rangoCanMapper;
	
	

	public  List<RangoCantidadProductosDto> getListRangoCantidadProductos() throws Exception{
		return this.rangoCanMapper.entityListToDtoList(this.rangoCanRep.findAll());
	}
	
	
	
	public RangoCantidadProductosDto  updatePuntajeRangoCantidadProductos(int idRangoCantidad, int puntaje) throws Exception{
		if(this.rangoCanRep.existsById(idRangoCantidad)) {
			this.rangoCanRep.ActualizarPuntaje(puntaje, idRangoCantidad);
			return this.rangoCanMapper.toDto(this.rangoCanRep.findById(idRangoCantidad).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
	
	
	
	

}
