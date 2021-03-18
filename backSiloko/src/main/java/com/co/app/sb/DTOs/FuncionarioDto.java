package com.co.app.sb.DTOs;

public class FuncionarioDto {
	
	private long id;
	
	
	private long codeEmploy;
	
	
	private String names;
	
	
	private String surNames;
	
	
	private String email;
	
	
	private RolFuncionarioDto rol;


	public FuncionarioDto(long id, long codeEmploy, String names, String surNames, String email,
			RolFuncionarioDto rol) {
		super();
		this.id = id;
		this.codeEmploy = codeEmploy;
		this.names = names;
		this.surNames = surNames;
		this.email = email;
		this.rol = rol;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getCodeEmploy() {
		return codeEmploy;
	}


	public void setCodeEmploy(long codeEmploy) {
		this.codeEmploy = codeEmploy;
	}


	public String getNames() {
		return names;
	}


	public void setNames(String names) {
		this.names = names;
	}


	public String getSurNames() {
		return surNames;
	}


	public void setSurNames(String surNames) {
		this.surNames = surNames;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public RolFuncionarioDto getRol() {
		return rol;
	}


	public void setRol(RolFuncionarioDto rol) {
		this.rol = rol;
	}
	
	
	

}
