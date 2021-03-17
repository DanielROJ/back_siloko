package com.co.app.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.app.sb.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

}
