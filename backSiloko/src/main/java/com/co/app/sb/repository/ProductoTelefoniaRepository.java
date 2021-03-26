package com.co.app.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.ProductoTelefonia;

public interface ProductoTelefoniaRepository extends JpaRepository<ProductoTelefonia, Long> {
	
	@Modifying(flushAutomatically = true)
	@Query(value="UPDATE PRODUCTO_TELEFONIA SET PUNTAJE_PRODUCTO_TEL = :puntaje  WHERE ID_PRODUCTO_TEL = :id",nativeQuery = true)
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idEstrato); 

}
