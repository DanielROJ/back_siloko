package com.co.app.sb.repository;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.CupoCredito;

public interface CupoCreditoRepository extends JpaRepository<CupoCredito, Long> {

	@Query(value = "select * from cupo_credito where id_cliente = :id", nativeQuery = true)
	Optional<CupoCredito> CupoCreditoCliente(@Param("id") long idCliente);
	
	@Transactional
	@Procedure(name = "CALCULO_CUPO_CREDITO")
	int GenerarCupoCreditoCliente(@Param("id_cliente") Long idCliente); 
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE CupoCredito cc SET cc.valorTotalCupo = :valorCupo WHERE cc.idCupoCredito = :id ")
	void UpdateCupoAsignado(@Param("valorCupo") BigDecimal valorCupo,@Param("id") long idCredito);
}
