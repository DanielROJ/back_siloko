package com.co.app.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.app.sb.model.Ciudad;

public interface CiudadRepository  extends JpaRepository<Ciudad, Long>{
	
	
	List<Ciudad> findBypais_idPais(long idPais);

}
