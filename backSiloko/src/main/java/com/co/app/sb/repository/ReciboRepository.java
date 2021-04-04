package com.co.app.sb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.ClienteProductoTel;
import com.co.app.sb.model.Recibo;
import com.co.app.sb.model.SolicitudCredito;

public interface ReciboRepository extends JpaRepository<Recibo, Long>, PagingAndSortingRepository<Recibo, Long> {

	List<Recibo> findAllBycliente_idCliente(long idCliente, Pageable pageable);
	
	long countBycliente_idCliente(long idCliente);
	
	
	
	
	
	@Query(value = "select * from cliente_producto_tel where id_cliente = :id", nativeQuery = true)
	List<ClienteProductoTel> GetProductosRecibos(@Param("id") long idCliente);
	
	
	
	
}
