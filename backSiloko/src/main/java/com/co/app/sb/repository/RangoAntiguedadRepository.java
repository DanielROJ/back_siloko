package com.co.app.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.RangoAntiguedad;

public interface RangoAntiguedadRepository extends JpaRepository<RangoAntiguedad, Long> {
	
	@Modifying(flushAutomatically = true)
	@Query(value="UPDATE RANGO_ANTIGUEDAD SET PUNTAJE_RANGO = :puntaje  WHERE ID_RANGO_ANT = :id",nativeQuery = true)
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idRangoAntiguedad);

}
