package com.co.app.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.co.app.sb.model.ClienteProductoTel;

public interface ClienteProductoTelRepository extends JpaRepository<ClienteProductoTel, Long> {
	
	@Query(nativeQuery = true, name = "SELECT * FROM CLIENTE_PRODUCTO_TEL WHERE id_cliente = ?")
	Optional<ClienteProductoTel> BuscaListProductosCliente(long idCliente);

}
