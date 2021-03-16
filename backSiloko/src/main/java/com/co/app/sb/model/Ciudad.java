package com.co.app.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CIUDAD")
public class Ciudad {
	
	@Id
	@Column(name = "id_ciudad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCiudad;
	
	@Column(name = "nombre_ciudad")
	private String nombreCiudad;
	
	@Column(name = "puntaje_ciudad")
	private int puntajeCiudad;
	
	@ManyToOne()
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;

	public Ciudad(String nombreCiudad, int puntajeCiudad, Pais pais) {
		super();
		this.nombreCiudad = nombreCiudad;
		this.puntajeCiudad = puntajeCiudad;
		this.pais = pais;
	}

	public Ciudad() {
		super();
	}

	public long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public int getPuntajeCiudad() {
		return puntajeCiudad;
	}

	public void setPuntajeCiudad(int puntajeCiudad) {
		this.puntajeCiudad = puntajeCiudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
	
	
	
	
}
