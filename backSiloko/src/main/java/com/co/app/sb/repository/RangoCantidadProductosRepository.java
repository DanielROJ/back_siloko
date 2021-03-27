package com.co.app.sb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.RangoCantidadProductos;

public interface RangoCantidadProductosRepository extends JpaRepository<RangoCantidadProductos, Integer> {

	@Modifying()
	@Transactional
	@Query(value="UPDATE RangoCantidadProductos rc SET rc.puntajeCantidadProducto = :puntaje  WHERE rc.idRangoCantidadProducto = :id")
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") int idRangoCantidad);
}
