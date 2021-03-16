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
@Table(name = "PRODUCTO_CREDITO")
public class ProductoCredito implements Serializable {

	
	@Id
	@Column(name = "id_producto_cred")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProductoCredito;
	
	
	@Column(name = "nombre_producto")
	private String nombreProducto;
	
	@Column(name = "codigo_siloko")
	private String codigoSiloko;
	
	@Column(name = "val_producto")
	private BigDecimal valorProducto;
	
	@ManyToOne()
	@JoinColumn(name = "id_almacen_convenio", nullable = false)
	private AlmacenConvenio almacenConvenio;

	public ProductoCredito(String nombreProducto, String codigoSiloko, BigDecimal valorProducto,
			AlmacenConvenio almacenConvenio) {
		super();
		this.nombreProducto = nombreProducto;
		this.codigoSiloko = codigoSiloko;
		this.valorProducto = valorProducto;
		this.almacenConvenio = almacenConvenio;
	}

	public ProductoCredito() {
		super();
	}

	public long getIdProductoCredito() {
		return idProductoCredito;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCodigoSiloko() {
		return codigoSiloko;
	}

	public void setCodigoSiloko(String codigoSiloko) {
		this.codigoSiloko = codigoSiloko;
	}

	public BigDecimal getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(BigDecimal valorProducto) {
		this.valorProducto = valorProducto;
	}

	public AlmacenConvenio getAlmacenConvenio() {
		return almacenConvenio;
	}

	public void setAlmacenConvenio(AlmacenConvenio almacenConvenio) {
		this.almacenConvenio = almacenConvenio;
	}
	
	
}
