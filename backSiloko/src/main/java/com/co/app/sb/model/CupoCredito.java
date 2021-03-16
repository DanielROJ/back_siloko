package com.co.app.sb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUPO_CREDITO")
public class CupoCredito implements Serializable {

	@Id
	@Column(name = "id_cupo_credito")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCupoCredito;
	
	@Column(name = "val_total_cupo")
	private BigDecimal valorTotalCupo;
	
	@Column(name = "val_cupo_uso")
	private BigDecimal valorCupoUso;
	
	@Column(name = "val_cupo_tramite")
	private BigDecimal valorCupoTramite;
	
	@ManyToOne()
	@JoinColumn(name = "cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne()
	@JoinColumn(name = "estado_cupo", nullable = false)
	private EstadoCupo estadoCupo;

	public CupoCredito(BigDecimal valorTotalCupo, BigDecimal valorCupoUso, BigDecimal valorCupoTramite, Cliente cliente,
			EstadoCupo estadoCupo) {
		super();
		this.valorTotalCupo = valorTotalCupo;
		this.valorCupoUso = valorCupoUso;
		this.valorCupoTramite = valorCupoTramite;
		this.cliente = cliente;
		this.estadoCupo = estadoCupo;
	}

	public CupoCredito() {
		super();
	}

	public long getIdCupoCredito() {
		return idCupoCredito;
	}

	public BigDecimal getValorTotalCupo() {
		return valorTotalCupo;
	}

	public void setValorTotalCupo(BigDecimal valorTotalCupo) {
		this.valorTotalCupo = valorTotalCupo;
	}

	public BigDecimal getValorCupoUso() {
		return valorCupoUso;
	}

	public void setValorCupoUso(BigDecimal valorCupoUso) {
		this.valorCupoUso = valorCupoUso;
	}

	public BigDecimal getValorCupoTramite() {
		return valorCupoTramite;
	}

	public void setValorCupoTramite(BigDecimal valorCupoTramite) {
		this.valorCupoTramite = valorCupoTramite;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoCupo getEstadoCupo() {
		return estadoCupo;
	}

	public void setEstadoCupo(EstadoCupo estadoCupo) {
		this.estadoCupo = estadoCupo;
	}
	
	
	

}
