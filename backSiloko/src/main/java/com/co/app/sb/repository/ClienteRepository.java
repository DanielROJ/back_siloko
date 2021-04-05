package com.co.app.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Optional<Cliente> findBydocumentoId(long documento);
	
	@Query(value = "SELECT c.correo FROM Cliente c WHERE c.documentoId = :documento")
	String getCorreoByDocumento(@Param("documento") long documento);


}
