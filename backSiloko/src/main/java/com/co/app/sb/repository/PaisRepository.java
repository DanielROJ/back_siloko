package com.co.app.sb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	
	
	@Modifying()
	@Transactional
	@Query(value="UPDATE Pais p SET p.puntajePais = :puntaje  WHERE p.idPais = :id")
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idPais);
	
	
}
