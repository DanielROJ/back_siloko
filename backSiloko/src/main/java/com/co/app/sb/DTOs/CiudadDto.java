package com.co.app.sb.DTOs;

public class CiudadDto {
	
	private long id;
	
	private String name;
	
	private int amountPoints;
	
	private PaisDto country;

	public CiudadDto(long id, String name, int amountPoints, PaisDto country) {
		super();
		this.id = id;
		this.name = name;
		this.amountPoints = amountPoints; 
		this.country = country; 
	} 

	public long getId() {
		return id;
	} 

	public void setId(long id) {
		this.id = id;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getamountPoints() {
		return amountPoints;
	}

	public void setamountPoints(int amountPoints) {
		this.amountPoints = amountPoints;
	}

	public PaisDto getCountry() {
		return country;
	}

	public void setCountry(PaisDto country) {
		this.country = country;
	}
	
	

}
