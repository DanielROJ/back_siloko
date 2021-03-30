package com.co.app.sb.repository;

import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.co.app.sb.model.SolicitudCredito;


public interface SolicitudCreditoRepository extends JpaRepository<SolicitudCredito, Long> {
	
	@Transactional()
	@Modifying(flushAutomatically = false)
	@Query(nativeQuery = true, value = "INSERT INTO solicitud_estado (id_solicitud_credito, id_estado_credito) VALUES (?,?)")
	void EnlazarEstadoSolicitud( long idSolicitud, long idEstadoCredito);
	
	
	Optional<SolicitudCredito> findBycodigoCredito(String codigo);
	
	
	@Query(nativeQuery = true,
	value ="SELECT id_estado_credito FROM solicitud_estado WHERE ID_SOLICITUD_CREDITO = ? ORDER BY ID_SOLICITUD_ESTADO ASC FETCH FIRST 1 ROWS ONLY")
	Optional<Long> BuscarUltimoEstadoCredito(long idSolicitudCredito);
	


}
