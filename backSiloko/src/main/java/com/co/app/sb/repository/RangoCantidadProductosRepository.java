package com.co.app.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.RangoCantidadProductos;

public interface RangoCantidadProductosRepository extends JpaRepository<RangoCantidadProductos, Long> {

	@Modifying(flushAutomatically = true)
	@Query(value="UPDATE RANGO_CAN_PRODUCTOS SET PUNTAJE_CAN_PRODUCTOS = :puntaje  WHERE ID_RANGO_CAN_P = :id",nativeQuery = true)
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idRangoCantidad);
}
