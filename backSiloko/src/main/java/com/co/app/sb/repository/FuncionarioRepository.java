package com.co.app.sb.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
	
	@Query(value = "SELECT f.correo FROM Funcionario f WHERE f.codigoEmpleado = :codigo")
	Optional<String> findEmail(@Param("codigo") long codigoEmpleado);
	
	
	Optional<Funcionario> findBycodigoEmpleado(long codigoEmpleado);
	

}
