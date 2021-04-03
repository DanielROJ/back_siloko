package com.co.app.sb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.co.app.sb.model.Recibo;

public interface ReciboRepository extends JpaRepository<Recibo, Long>, PagingAndSortingRepository<Recibo, Long> {

	List<Recibo> findAllBycliente_idCliente(long idCliente, Pageable pageable);
	
	long countBycliente_idCliente(long idCliente);
}
