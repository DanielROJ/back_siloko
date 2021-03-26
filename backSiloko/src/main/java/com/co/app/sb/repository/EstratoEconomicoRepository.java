package com.co.app.sb.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.EstratoEconomico;

public interface EstratoEconomicoRepository extends JpaRepository<EstratoEconomico, Long> {
	
	@Modifying(flushAutomatically = true)
	@Query(value="UPDATE ESTRATO_ECONOMICO SET PUNTAJE_ESTRATO = :puntaje  WHERE ID_ESTRATO = :id",nativeQuery = true)
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idEstrato);
}
