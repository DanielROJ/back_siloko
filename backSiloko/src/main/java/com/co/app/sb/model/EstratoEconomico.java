package com.co.app.sb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTRATO_ECONOMICO")
public class EstratoEconomico implements Serializable {

	 
	@Id
	@Column(name = "id_estrato")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstratoEconomico;
	
	@Column(name = "numero_estrato")
	private int numeroEstrato;
	
	@Column(name="puntaje_estrato")
	private int puntajeEstrato;
	
	

	public EstratoEconomico() {
		super();
	}

	public EstratoEconomico(int numeroEstrato, int puntajeEstrato) {
		super();
		this.numeroEstrato = numeroEstrato;
		this.puntajeEstrato = puntajeEstrato;
	}

	public int getIdEstratoEconomico() {
		return idEstratoEconomico;
	}

	public void setIdEstratoEconomico(int idEstratoEconomico) {
		this.idEstratoEconomico = idEstratoEconomico;
	}

	public int getNumeroEstrato() {
		return numeroEstrato;
	}

	public void setNumeroEstrato(int numeroEstrato) {
		this.numeroEstrato = numeroEstrato;
	}

	public int getPuntajeEstrato() {
		return puntajeEstrato;
	}

	public void setPuntajeEstrato(int puntajeEstrato) {
		this.puntajeEstrato = puntajeEstrato;
	}
	
	
	
	
	
}
