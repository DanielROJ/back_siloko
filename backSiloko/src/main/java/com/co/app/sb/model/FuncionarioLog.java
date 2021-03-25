package com.co.app.sb.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIO_LOG")
public class FuncionarioLog implements Serializable {

	@Id
	@Column(name = "id_funcionario_log")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFuncionarioLog;
	
	
	@ManyToOne()
	@JoinColumn(name = "id_tipo_log", nullable = false)
	private TipoLog tipoLog;
	
	@ManyToOne()
	@JoinColumn(name = "id_funcionario", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne()
	@JoinColumn(name = "id_cupo_credito", nullable = false)
	private CupoCredito cupoCredito;
	
	@Column(name = "fecha_log")
	private Date fechaLog;

	public FuncionarioLog(TipoLog tipoLog, Funcionario funcionario, CupoCredito cupoCredito) {
		super();
		this.tipoLog = tipoLog;
		this.funcionario = funcionario;
		this.cupoCredito = cupoCredito;
	}

	public FuncionarioLog() {
		super();
	}

	public long getIdFuncionarioLog() {
		return idFuncionarioLog;
	}

	public void setIdFuncionarioLog(long idFuncionarioLog) {
		this.idFuncionarioLog = idFuncionarioLog;
	}

	public TipoLog getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(TipoLog tipoLog) {
		this.tipoLog = tipoLog;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public CupoCredito getCupoCredito() {
		return cupoCredito;
	}

	public void setCupoCredito(CupoCredito cupoCredito) {
		this.cupoCredito = cupoCredito;
	}

	public Date getFechaLog() {
		return fechaLog;
	}

	public void setFechaLog(Date fechaLog) {
		this.fechaLog = fechaLog;
	}
	
	
	
	
	
}
