package com.co.app.sb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO_CUPO")
public class EstadoCupo implements Serializable {

	@Id
	@Column(name = "id_estado_cupo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstadoCupo;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "descripcion")
	private String descripcion;

	public EstadoCupo(String estado, String descripcion) {
		super();
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public EstadoCupo() {
		super();
	}

	public int getIdEstadoCupo() {
		return idEstadoCupo;
	}

	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
}
