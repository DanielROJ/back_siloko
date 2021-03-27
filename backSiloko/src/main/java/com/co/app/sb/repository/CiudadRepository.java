package com.co.app.sb.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.Ciudad;

public interface CiudadRepository  extends JpaRepository<Ciudad, Long>{
	
	
	List<Ciudad> findBypais_idPais(long idPais);
	
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE Ciudad c SET c.puntajeCiudad = :puntaje  WHERE c.idCiudad = :id")
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idCiudad);

}
