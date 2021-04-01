package com.co.app.sb.DTOs;

import java.math.BigDecimal;

public class ClienteProductoTelDto {

	
	private long id;
	
	private ProductoTelefoniaDto productTel;
	
	private BigDecimal priceProduct;
	
	private long numberLine;

	public ClienteProductoTelDto(long id, ProductoTelefoniaDto productTel, BigDecimal priceProduct, long numberLine) {
		super();
		this.id = id;
		this.productTel = productTel;
		this.priceProduct = priceProduct;
		this.numberLine = numberLine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductoTelefoniaDto getProductTel() {
		return productTel;
	}

	public void setProductTel(ProductoTelefoniaDto productTel) {
		this.productTel = productTel;
	}

	public BigDecimal getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(BigDecimal priceProduct) {
		this.priceProduct = priceProduct;
	}

	public long getNumberLine() {
		return numberLine;
	}

	public void setNumberLine(long numberLine) {
		this.numberLine = numberLine;
	}
	
	
}
