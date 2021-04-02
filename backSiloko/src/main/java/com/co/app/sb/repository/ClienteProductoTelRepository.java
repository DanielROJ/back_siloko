package com.co.app.sb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.ClienteProductoTel;
import com.co.app.sb.model.CupoCredito;

public interface ClienteProductoTelRepository extends JpaRepository<ClienteProductoTel, Long> {
	
	@Query(value = "select * from cliente_producto_tel where id_cliente = :id", nativeQuery = true)
	List<ClienteProductoTel> ClienteProductos(@Param("id") long idCliente);

}
