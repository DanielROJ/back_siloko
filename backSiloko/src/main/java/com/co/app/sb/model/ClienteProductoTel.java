package com.co.app.sb.model;

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
@Table(name = "CLIENTE_PRODUCTO_TEL")
public class ClienteProductoTel {
	
	@Id
	@Column(name = "id_cliente_producto_tel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClienteProductoTel;
	
	
	@ManyToOne()
	@JoinColumn(name = "id_producto_tel", nullable = false)
	private ProductoTelefonia productoTel;
	
	@Column(name = "precio_producto")
	private BigDecimal precioProducto;
	
	@Column(name = "numero_linea")
	private long numeroLinea;
	
	
	public ClienteProductoTel(){
		
	}


	public long getIdClienteProductoTel() {
		return idClienteProductoTel;
	}


	public void setIdClienteProductoTel(long idClienteProductoTel) {
		this.idClienteProductoTel = idClienteProductoTel;
	}


	public ProductoTelefonia getProductoTel() {
		return productoTel;
	}


	public void setProductoTel(ProductoTelefonia productoTel) {
		this.productoTel = productoTel;
	}


	public BigDecimal getPrecioProducto() {
		return precioProducto;
	}


	public void setPrecioProducto(BigDecimal precioProducto) {
		this.precioProducto = precioProducto;
	}


	public long getNumeroLinea() {
		return numeroLinea;
	}


	public void setNumeroLinea(long numeroLinea) {
		this.numeroLinea = numeroLinea;
	}
	
	
	

}
