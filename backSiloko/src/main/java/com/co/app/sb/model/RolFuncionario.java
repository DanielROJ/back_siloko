package com.co.app.sb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROL_FUNCIONARIO")
public class RolFuncionario implements Serializable {

	@Id
	@Column(name = "id_rol_fun")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRolFuncionario;
	
	@Column(name = "nombre_rol")
	private String nombreRol;

	public RolFuncionario(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}

	public RolFuncionario() {
		super();
	}

	public long getIdRolFuncionario() {
		return idRolFuncionario;
	}

	public void setIdRolFuncionario(long idRolFuncionario) {
		this.idRolFuncionario = idRolFuncionario;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	
	
	
	
	
}
