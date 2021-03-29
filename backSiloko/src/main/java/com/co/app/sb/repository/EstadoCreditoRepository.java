package com.co.app.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.app.sb.model.EstadoCredito;

@Repository
public interface EstadoCreditoRepository extends JpaRepository<EstadoCredito, Long> {

}
