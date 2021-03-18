package com.co.app.sb.DTOs;

import java.math.BigDecimal;

public class ProductoCreditoDto {

	private long id;
	
	private String nameProduct;
	
	private String codeSiloko;
	
	private BigDecimal valueProduct;
	
	private AlmacenConvenioDto store;

	public ProductoCreditoDto(long id, String nameProduct, String codeSiloko, BigDecimal valueProduct,
			AlmacenConvenioDto store) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.codeSiloko = codeSiloko;
		this.valueProduct = valueProduct;
		this.store = store;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getCodeSiloko() {
		return codeSiloko;
	}

	public void setCodeSiloko(String codeSiloko) {
		this.codeSiloko = codeSiloko;
	}

	public BigDecimal getValueProduct() {
		return valueProduct;
	}

	public void setValueProduct(BigDecimal valueProduct) {
		this.valueProduct = valueProduct;
	}

	public AlmacenConvenioDto getStore() {
		return store;
	}

	public void setStore(AlmacenConvenioDto store) {
		this.store = store;
	}
	
	

}
