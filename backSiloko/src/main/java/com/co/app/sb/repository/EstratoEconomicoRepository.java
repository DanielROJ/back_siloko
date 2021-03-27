package com.co.app.sb.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.EstratoEconomico;

public interface EstratoEconomicoRepository extends JpaRepository<EstratoEconomico, Integer> {
	
	
	@Modifying()
	@Transactional()
	@Query(value="UPDATE EstratoEconomico es SET es.puntajeEstrato = :puntaje  WHERE es.idEstratoEconomico = :id")
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") int idEstrato);
}
