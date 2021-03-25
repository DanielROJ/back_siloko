package com.co.app.sb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TIPO_LOG")
public class TipoLog implements Serializable{

	@Id
	@Column(name = "id_tipo_log")
	private int idTipoLog;
	
	@Column(name = "descripcion")
	private String descripcion;

	public TipoLog(int idTipoLog, String descripcion) {
		super();
		this.idTipoLog = idTipoLog;
		this.descripcion = descripcion;
	}

	public TipoLog() {
		super();
	}

	public int getIdTipoLog() {
		return idTipoLog;
	}

	public void setIdTipoLog(int idTipoLog) {
		this.idTipoLog = idTipoLog;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
