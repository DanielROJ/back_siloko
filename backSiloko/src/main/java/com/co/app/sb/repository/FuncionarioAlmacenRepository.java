package com.co.app.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.FuncionarioAlmacen;

public interface FuncionarioAlmacenRepository extends JpaRepository<FuncionarioAlmacen, Long> {

	@Query(value = "SELECT f.correo FROM FuncionarioAlmacen f WHERE f.codigoEmpleado = :codigo")
	Optional<String> findEmail(@Param("codigo") long codigoEmpleado);
	
	Optional<FuncionarioAlmacen> findBycodigoEmpleado(long codigo);
	
}
