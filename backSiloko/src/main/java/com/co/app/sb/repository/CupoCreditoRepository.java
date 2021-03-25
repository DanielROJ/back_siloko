package com.co.app.sb.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.CupoCredito;

public interface CupoCreditoRepository extends JpaRepository<CupoCredito, Long> {

	@Query(value = "select * from cupo_credito where id_cliente = :id", nativeQuery = true)
	Optional<CupoCredito> CupoCreditoCliente(@Param("id") long idCliente);
}
