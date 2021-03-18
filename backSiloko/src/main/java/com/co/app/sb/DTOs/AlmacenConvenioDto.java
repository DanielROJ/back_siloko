package com.co.app.sb.DTOs;

public class AlmacenConvenioDto {
	
	private long id;
	
	private long codeNit;
	
	private String name;
	
	private PaisDto country;

	public AlmacenConvenioDto(long id, long codeNit, String name, PaisDto country) {
		super();
		this.id = id;
		this.codeNit = codeNit;
		this.name = name;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCodeNit() {
		return codeNit;
	}

	public void setCodeNit(long codeNit) {
		this.codeNit = codeNit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PaisDto getCountry() {
		return country;
	}

	public void setCountry(PaisDto country) {
		this.country = country;
	}
	
	
	

}
