package com.co.app.sb.services;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.app.sb.DTOs.ProductoTelefoniaDto;
import com.co.app.sb.Mappers.ProductoTelefoniaMapper;
import com.co.app.sb.repository.ProductoTelefoniaRepository;

@Service
public class ProductoTelefoniaService {
	
	
	@Autowired
	private ProductoTelefoniaRepository productoTelRep;
	
	@Autowired
	private ProductoTelefoniaMapper productoTelMapper;
	
	
	/**
	 * Metodo que devuelve todos los productos de telefonia de la bade de datos !!cuidado!!
	 * @return
	 * @throws Exception
	 */
	public  List<ProductoTelefoniaDto> getListProductosTelefonia() throws Exception{
		return this.productoTelMapper.entityListToDtoList(this.productoTelRep.findAll());
	}
	
	
	/**
	 * Metodo que actualiza elpuntaje de credito de un producto de telefonia
	 * @param idProductoTelefonia
	 * @param puntaje
	 * @return
	 * @throws Exception
	 */
	public ProductoTelefoniaDto  updatePuntajeProductoTelfonia(long idProductoTelefonia, int puntaje) throws Exception{
		if(this.productoTelRep.existsById(idProductoTelefonia)) {
			this.productoTelRep.ActualizarPuntaje(puntaje, idProductoTelefonia);
			return this.productoTelMapper.toDto(this.productoTelRep.findById(idProductoTelefonia).orElseThrow());
		}else {
			throw new NoSuchElementException();
		}
	}
	
	
	

}
