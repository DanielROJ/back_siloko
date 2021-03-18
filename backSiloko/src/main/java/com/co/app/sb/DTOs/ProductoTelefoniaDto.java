package com.co.app.sb.DTOs;

public class ProductoTelefoniaDto {

	private long id;
	
	private String nameProduct;
	
	private int numberMinutes;
	
	private int amountPoints;

	public ProductoTelefoniaDto(long id, String nameProduct, int numberMinutes, int amountPoints) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.numberMinutes = numberMinutes;
		this.amountPoints = amountPoints;
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

	public int getNumberMinutes() {
		return numberMinutes;
	}

	public void setNumberMinutes(int numberMinutes) {
		this.numberMinutes = numberMinutes;
	}

	public int getAmountPoints() {
		return amountPoints;
	}

	public void setAmountPoints(int amountPoints) {
		this.amountPoints = amountPoints;
	}
	
	
}
