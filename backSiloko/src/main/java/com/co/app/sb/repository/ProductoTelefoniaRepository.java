package com.co.app.sb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.ProductoTelefonia;

public interface ProductoTelefoniaRepository extends JpaRepository<ProductoTelefonia, Long> {
	
	@Modifying()
	@Transactional
	@Query(value="UPDATE ProductoTelefonia pt SET pt.puntajeProductoTelefonia = :puntaje  WHERE pt.idProductoTelefonia = :id")
	void ActualizarPuntaje(@Param("puntaje") int puntaje, @Param("id") long idEstrato); 

}
