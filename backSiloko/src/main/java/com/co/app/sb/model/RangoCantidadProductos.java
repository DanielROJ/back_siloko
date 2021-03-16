package com.co.app.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RANGO_CAN_PRODUCTOS")
public class RangoCantidadProductos {

	
	@Id
	@Column(name = "id_rango_can_p")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRangoCantidadProducto;
	
	@Column(name = "rango")
	private String rango;
	
	@Column(name = "puntaje_can_productos")
	private int puntajeCantidadProducto;

	public RangoCantidadProductos(String rango, int puntajeCantidadProducto) {
		super();
		this.rango = rango;
		this.puntajeCantidadProducto = puntajeCantidadProducto;
	}

	public RangoCantidadProductos() {
		super();
	}

	public int getIdRangoCantidadProducto() {
		return idRangoCantidadProducto;
	}

	public void setIdRangoCantidadProducto(int idRangoCantidadProducto) {
		this.idRangoCantidadProducto = idRangoCantidadProducto;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public int getPuntajeCantidadProducto() {
		return puntajeCantidadProducto;
	}

	public void setPuntajeCantidadProducto(int puntajeCantidadProducto) {
		this.puntajeCantidadProducto = puntajeCantidadProducto;
	}
	
	
	
	
	
	
}
