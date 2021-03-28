package com.co.app.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.ProductoCreditoDto;
import com.co.app.sb.Mappers.ProductoCreditoMapper;
import com.co.app.sb.model.ProductoCredito;
import com.co.app.sb.repository.ProductoCreditoRepository;

@Service
public class ProductoCreditoService {
	
	@Autowired
	private ProductoCreditoRepository productoRep;
	
	@Autowired
	private ProductoCreditoMapper productoMapper;
	
	
	
	
	public ProductoCreditoDto getProductoCreditoBySilkoCode(String silokoCode) throws Exception {
		ProductoCredito producto = this.productoRep.findBycodigoSiloko(silokoCode.toLowerCase()).orElseThrow();
		return this.productoMapper.toDto(producto);
	}
	

}
