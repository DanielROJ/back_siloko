package com.co.app.sb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS")
public class Pais implements Serializable {
	
	@Id
	@Column(name = "id_pais")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPais;
	
	@Column(name = "nombre_pais")
	private String nombrePais;
	
	@Column(name="puntaje_pais")
	private int puntajePais;
	
	@Column(name="moneda_pais")
	private String moneda;
	
	@Column(name="valor_punto")
	private BigDecimal valorPunto;
	

	public Pais(String nombrePais, int puntajePais, String moneda, BigDecimal valorPunto) {
		super();
		this.nombrePais = nombrePais;
		this.puntajePais = puntajePais;
		this.moneda = moneda;
		this.valorPunto = valorPunto;
	}

	public Pais() {
		super();
	}

	public long getIdPais() {
		return idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public int getPuntajePais() {
		return puntajePais;
	}

	public void setPuntajePais(int puntajePais) {
		this.puntajePais = puntajePais;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getValorPunto() {
		return valorPunto;
	}

	public void setValorPunto(BigDecimal valorPunto) {
		this.valorPunto = valorPunto;
	}
	
	
	
	

}
