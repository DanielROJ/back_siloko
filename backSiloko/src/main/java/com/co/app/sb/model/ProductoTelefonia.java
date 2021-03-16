package com.co.app.sb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO_TELEFONIA")
public class ProductoTelefonia implements Serializable {

	
	@Id
	@Column(name = "id_producto_tel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProductoTelefonia;
	
	@Column(name = "nombre_producto")
	private String nombreProducto;
	
	@Column(name = "numero_minutos")
	private int numeroMinutos;
	
	@Column(name="puntaje_producto_tel")
	private int puntajeProductoTelefonia;

	public ProductoTelefonia(String nombreProducto, int numeroMinutos, int puntajeProductoTelefonia) {
		super();
		this.nombreProducto = nombreProducto;
		this.numeroMinutos = numeroMinutos;
		this.puntajeProductoTelefonia = puntajeProductoTelefonia;
	}

	public ProductoTelefonia() {
		super();
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getNumeroMinutos() {
		return numeroMinutos;
	}

	public void setNumeroMinutos(int numeroMinutos) {
		this.numeroMinutos = numeroMinutos;
	}

	public int getPuntajeProductoTelefonia() {
		return puntajeProductoTelefonia;
	}

	public void setPuntajeProductoTelefonia(int puntajeProductoTelefonia) {
		this.puntajeProductoTelefonia = puntajeProductoTelefonia;
	}
		
	
}
