package com.co.app.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RANGO_ANTIGUEDAD")
public class RangoAntiguedad {
	
	
	@Id
	@Column(name = "id_rango_ant")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRangoAntiguedad;
	
	@Column(name = "rango")
	private String rango;
	
	@Column(name="puntaje_rango")
	private int puntajeRango;

	public RangoAntiguedad(String rango, int puntajeRango) {
		super();
		this.rango = rango;
		this.puntajeRango = puntajeRango;
	}

	public RangoAntiguedad() {
		super();
	}

	public long getIdRangoAntiguedad() {
		return idRangoAntiguedad;
	}

	public void setIdRangoAntiguedad(long idRangoAntiguedad) {
		this.idRangoAntiguedad = idRangoAntiguedad;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public int getPuntajeRango() {
		return puntajeRango;
	}

	public void setPuntajeRango(int puntajeRango) {
		this.puntajeRango = puntajeRango;
	}
	

}
