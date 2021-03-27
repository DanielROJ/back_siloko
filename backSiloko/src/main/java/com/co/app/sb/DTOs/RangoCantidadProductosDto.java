package com.co.app.sb.DTOs;

public class RangoCantidadProductosDto {

	
	private int id;
	
	private String rangeAmountProducts;
	
	private int amountPoints;

	public RangoCantidadProductosDto(int id, String rangeAmountProducts, int amountPoints) {
		super();
		this.id = id;
		this.rangeAmountProducts = rangeAmountProducts;
		this.amountPoints = amountPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRangeAmountProducts() {
		return rangeAmountProducts;
	}

	public void setRangeAmountProducts(String rangeAmountProducts) {
		this.rangeAmountProducts = rangeAmountProducts;
	}

	public int getAmountPoints() {
		return amountPoints;
	}

	public void setAmountPoints(int amountPoints) {
		this.amountPoints = amountPoints;
	}

}
