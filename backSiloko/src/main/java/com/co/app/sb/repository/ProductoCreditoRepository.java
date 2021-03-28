package com.co.app.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.app.sb.model.ProductoCredito;

public interface ProductoCreditoRepository extends JpaRepository<ProductoCredito, Long> {
	
	
	Optional<ProductoCredito> findBycodigoSiloko(String codigoSiloko);
	
	

}
