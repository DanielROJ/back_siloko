package com.co.app.sb.DTOs;

public class RolFuncionarioDto {
		
	private long id;
	
	private String nameRol;

	public RolFuncionarioDto(long id, String nameRol) {
		super();
		this.id = id;
		this.nameRol = nameRol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameRol() {
		return nameRol;
	}

	public void setNameRol(String nameRol) {
		this.nameRol = nameRol;
	}
	
	
}
