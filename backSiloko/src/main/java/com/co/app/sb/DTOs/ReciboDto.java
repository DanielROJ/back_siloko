package com.co.app.sb.DTOs;

import java.math.BigDecimal;
import java.sql.Date;

public class ReciboDto {

	private long id;

	private BigDecimal valTotalCuotaCredit;

	private BigDecimal valTotalProduct;

	private BigDecimal valTotalCredit;

	private BigDecimal total;

	private int statusPay;

	private Date dateGenerated;

	private Date dateLimPay;

	private ClienteDto client;

	public ReciboDto() {
		super();
	}

	public ReciboDto(long id, BigDecimal valTotalCuotaCredit, BigDecimal valTotalProduct, BigDecimal valTotalCredit,
			BigDecimal total, int statusPay, Date dateGenerated, Date dateLimPay, ClienteDto client) {
		super();
		this.id = id;
		this.valTotalCuotaCredit = valTotalCuotaCredit;
		this.valTotalProduct = valTotalProduct;
		this.valTotalCredit = valTotalCredit;
		this.total = total;
		this.statusPay = statusPay;
		this.dateGenerated = dateGenerated;
		this.dateLimPay = dateLimPay;
		this.client = client;
	}

	public ClienteDto getClient() {
		return client;
	}

	public void setClient(ClienteDto client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getValTotalCuotaCredit() {
		return valTotalCuotaCredit;
	}

	public void setValTotalCuotaCredit(BigDecimal valTotalCuotaCredit) {
		this.valTotalCuotaCredit = valTotalCuotaCredit;
	}

	public BigDecimal getValTotalProduct() {
		return valTotalProduct;
	}

	public void setValTotalProduct(BigDecimal valTotalProduct) {
		this.valTotalProduct = valTotalProduct;
	}

	public BigDecimal getValTotalCredit() {
		return valTotalCredit;
	}

	public void setValTotalCredit(BigDecimal valTotalCredit) {
		this.valTotalCredit = valTotalCredit;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public int getStatusPay() {
		return statusPay;
	}

	public void setStatusPay(int statusPay) {
		this.statusPay = statusPay;
	}

	public Date getDateGenerated() {
		return dateGenerated;
	}

	public void setDateGenerated(Date dateGenerated) {
		this.dateGenerated = dateGenerated;
	}

	public Date getDateLimPay() {
		return dateLimPay;
	}

	public void setDateLimPay(Date dateLimPay) {
		this.dateLimPay = dateLimPay;
	}

}
