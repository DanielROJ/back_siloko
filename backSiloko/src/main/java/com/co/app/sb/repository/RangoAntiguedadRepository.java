package com.co.app.sb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.RangoAntiguedad;

public interface RangoAntiguedadRepository extends JpaRepository<RangoAntiguedad, Long> {
	
	@Modifying()
	@Transactional
	@Query(value="UPDATE RangoAntiguedad ra SET ra.puntajeRango = :puntaje  WHERE ra.idRangoAntiguedad = :id")
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idRangoAntiguedad);

}
