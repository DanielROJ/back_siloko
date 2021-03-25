package com.co.app.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.app.sb.model.CupoCredito;

public interface CupoCreditoRepository extends JpaRepository<CupoCredito, Long> {

	Optional<CupoCredito> findByuser_idCliente(long idCliente);
}
