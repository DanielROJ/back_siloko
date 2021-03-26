package com.co.app.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	
	
	@Modifying(flushAutomatically = true)
	@Query(value="UPDATE PAIS SET PUNTAJE_PAIS = :puntaje  WHERE ID_PAIS = :id",nativeQuery = true)
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idPais);
	
	
}
