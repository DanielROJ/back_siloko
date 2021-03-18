package com.co.app.sb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.app.sb.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
	
	@Query(value = "SELECT f.correo FROM FUNCIONARIO f WHERE f.codigo_empleado = :codigo")
	String findEmail(@Param("codigo") long codigoEmpleado);
	

}
