package com.co.app.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.app.sb.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
