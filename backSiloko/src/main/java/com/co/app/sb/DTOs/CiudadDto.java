package com.co.app.sb.DTOs;

public class CiudadDto {
	
	private long id;
	
	private String name;
	
	private int points;
	
	private PaisDto country;

	public CiudadDto(long id, String name, int points, PaisDto country) {
		super();
		this.id = id;
		this.name = name;
		this.points = points; 
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public PaisDto getCountry() {
		return country;
	}

	public void setCountry(PaisDto country) {
		this.country = country;
	}
	
	

}
