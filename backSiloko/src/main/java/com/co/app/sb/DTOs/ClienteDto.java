package com.co.app.sb.DTOs;

import java.sql.Date;

public class ClienteDto {
	
	
	private long id;
	
	private String names;
	
	private String surNames;
	
	private String email;
	
	private Date dateRegister;
	
	private long idDocument;
	
	private CiudadDto city;
	
	private RangoAntiguedadDto rangeOld;
	
	private EstratoEconomicoDto classEconomic;
	
	private  RangoCantidadProductosDto rangeAmountProducts;
	
	private CupoCreditoDto credit;
	

	

	public ClienteDto(long id, String names, String surNames, String email, Date dateRegister, long idDocument,
			CiudadDto city, RangoAntiguedadDto rangeOld, EstratoEconomicoDto classEconomic,
			RangoCantidadProductosDto rangeAmountProducts, CupoCreditoDto credit) {
		super();
		this.id = id;
		this.names = names;
		this.surNames = surNames;
		this.email = email;
		this.dateRegister = dateRegister;
		this.idDocument = idDocument;
		this.city = city;
		this.rangeOld = rangeOld;
		this.classEconomic = classEconomic;
		this.rangeAmountProducts = rangeAmountProducts;
		this.credit = credit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurNames() {
		return surNames;
	}

	public void setSurNames(String surNames) {
		this.surNames = surNames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(long idDocument) {
		this.idDocument = idDocument;
	}

	public CiudadDto getCity() {
		return city;
	}

	public void setCity(CiudadDto city) {
		this.city = city;
	}

	public RangoAntiguedadDto getRangeOld() {
		return rangeOld;
	}

	public void setRangeOld(RangoAntiguedadDto rangeOld) {
		this.rangeOld = rangeOld;
	}

	public EstratoEconomicoDto getClassEconomic() {
		return classEconomic;
	}

	public void setClassEconomic(EstratoEconomicoDto classEconomic) {
		this.classEconomic = classEconomic;
	}

	public RangoCantidadProductosDto getRangeAmountProducts() {
		return rangeAmountProducts;
	}

	public void setRangeAmountProducts(RangoCantidadProductosDto rangeAmountProducts) {
		this.rangeAmountProducts = rangeAmountProducts;
	}

	public CupoCreditoDto getCredit() {
		return credit;
	}

	public void setCredit(CupoCreditoDto credit) {
		this.credit = credit;
	}
	

}
