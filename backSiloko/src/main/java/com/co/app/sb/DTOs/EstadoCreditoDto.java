package com.co.app.sb.DTOs;

public class EstadoCreditoDto {

	private long id;
	
	private String status;
	
	private String description;

	public EstadoCreditoDto(long id, String status, String description) {
		super();
		this.id = id;
		this.status = status;
		this.description = description;
	}

	public EstadoCreditoDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
