package com.co.app.sb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ALMACEN_CONVENIO")
public class AlmacenConvenio implements Serializable {
	
	@Id
	@Column(name = "id_almacen_convenio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  idAlmacen;
	
	@Column(name = "nit")
	private long nit;
	
	@Column(name = "nombre_almacen")
	private String nombreAlmacen;
	
	@ManyToOne()
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;

	public AlmacenConvenio() {
		super();
	}

	public AlmacenConvenio(long nit, String nombreAlmacen, Pais pais) {
		super();
		this.nit = nit;
		this.nombreAlmacen = nombreAlmacen;
		this.pais = pais;
	}




	public long getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(long idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public long getNit() {
		return nit;
	}

	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
