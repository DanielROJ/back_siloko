package com.co.app.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO_CREDITO")
public class EstadoCredito {
	
	@Id
	@Column(name = "id_estado_credito")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstadoCredito;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name="descripcion")
	private String descripcion;

	public EstadoCredito(int idEstadoCredito, String estado, String descripcion) {
		super();
		this.idEstadoCredito = idEstadoCredito;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public EstadoCredito() {
		super();
	}

	public long getIdEstadoCredito() {
		return idEstadoCredito;
	}

	public void setIdEstadoCredito(long idEstadoCredito) {
		this.idEstadoCredito = idEstadoCredito;
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
