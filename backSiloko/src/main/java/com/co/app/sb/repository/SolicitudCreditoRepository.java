package com.co.app.sb.repository;

import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.app.sb.model.SolicitudCredito;

@Repository
public interface SolicitudCreditoRepository extends JpaRepository<SolicitudCredito, Long> {
	
	@Transactional()
	@Modifying(flushAutomatically = false)
	@Query(nativeQuery = true, value = "INSERT INTO solicitud_estado (id_solicitud_credito, id_estado_credito) VALUES (?,?)")
	void EnlazarEstadoSolicitud( long idSolicitud, long idEstadoCredito);
	
	
	Optional<SolicitudCredito> findBycodigoCredito(String codigo);
	
	
	@Query(nativeQuery = true,
	value ="SELECT id_estado_credito FROM solicitud_estado WHERE ID_SOLICITUD_CREDITO = ? ORDER BY ID_SOLICITUD_ESTADO DESC FETCH FIRST 1 ROWS ONLY")
	Optional<Long> BuscarUltimoEstadoCredito(long idSolicitudCredito);
	
	@Transactional()
	@Modifying(flushAutomatically = false)
	@Query(value = "UPDATE solicitud_credito SET numero_cuotas = ?, id_funcionario_alm = ? WHERE id_solicitud_credito= ?", nativeQuery = true)
	void ParametrosFinanciacion(int numeroCuotas,long idFuncionario,long idSolicitud);

	
	
	@Query(value = "SELECT sc FROM SolicitudCredito sc WHERE sc.idSolicitudCredito= :id")
	Optional<SolicitudCredito> BuscaPorId(@Param("id") long idSolicitud);
	
	
}
