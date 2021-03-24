package com.co.app.sb.DTOs;

public class EstadoCupoDto {
	
	private int id;
	
	private String status;
	
	private String description;


	public EstadoCupoDto() {
		super();
	}

	public EstadoCupoDto(int id, String status, String description) {
		super();
		this.id = id;
		this.status = status;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
