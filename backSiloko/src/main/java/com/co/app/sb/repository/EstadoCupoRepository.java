package com.co.app.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.app.sb.model.EstadoCupo;

public interface EstadoCupoRepository extends JpaRepository<EstadoCupo, Integer> {
	
	
	Optional<EstadoCupo> findByestado(String estado);

}
