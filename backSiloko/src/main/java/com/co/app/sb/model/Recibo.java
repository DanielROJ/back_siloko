package com.co.app.sb.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RECIBO")
public class Recibo {
	
	@Id
	@Column(name = "id_recibo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRecibo;
	
	@Column(name = "VAL_TOTAL_CREDITOS")
	private BigDecimal valorTotalCreditos; //Total a pagar este mes en cuotas
	
	@Column(name = "VAL_TOTAL_PRODUCTOS_TEL")
	private BigDecimal valorTotalProductosTel;
	
	@Column(name = "TOTAL_PAGAR_CREDITOS")
	private BigDecimal totalPagarCreditos; //Total a pagar, saldos totales de los productos a credito
	
	@Column(name="TOTAL")
	private BigDecimal total;
	
	@Column(name = "ESTADO_PAGO")
	private int estadoPago;
	
	@Column(name = "FECHA_GENERACION")
	private Date fechaGeneracion;
	
	@Column(name = "FECHA_LIM_PAGO")
	private Date fechaLimPago;

	public Recibo() {
		super();
	}

	public Recibo(long idRecibo, BigDecimal valorTotalCreditos, BigDecimal valorTotalProductosTel,
			BigDecimal totalPagarCreditos, BigDecimal total, int estadoPago, Date fechaGeneracion, Date fechaLimPago) {
		super();
		this.idRecibo = idRecibo;
		this.valorTotalCreditos = valorTotalCreditos;
		this.valorTotalProductosTel = valorTotalProductosTel;
		this.totalPagarCreditos = totalPagarCreditos;
		this.total = total;
		this.estadoPago = estadoPago;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaLimPago = fechaLimPago;
	}

	public long getIdRecibo() {
		return idRecibo;
	}

	public void setIdRecibo(long idRecibo) {
		this.idRecibo = idRecibo;
	}

	public BigDecimal getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(BigDecimal valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}

	public BigDecimal getValorTotalProductosTel() {
		return valorTotalProductosTel;
	}

	public void setValorTotalProductosTel(BigDecimal valorTotalProductosTel) {
		this.valorTotalProductosTel = valorTotalProductosTel;
	}

	public BigDecimal getTotalPagarCreditos() {
		return totalPagarCreditos;
	}

	public void setTotalPagarCreditos(BigDecimal totalPagarCreditos) {
		this.totalPagarCreditos = totalPagarCreditos;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public int getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(int estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaLimPago() {
		return fechaLimPago;
	}

	public void setFechaLimPago(Date fechaLimPago) {
		this.fechaLimPago = fechaLimPago;
	}
	
	

}
