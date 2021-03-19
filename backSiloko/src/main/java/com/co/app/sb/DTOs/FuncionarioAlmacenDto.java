package com.co.app.sb.DTOs;

public class FuncionarioAlmacenDto {

	
	private long id;
	
	
	private long codeEmploy;
	
	
	private String names;
	
	
	private String surNames;
	
	
	private String email;
	
	
	private AlmacenConvenioDto store;	
	
	public FuncionarioAlmacenDto(long id, long codeEmploy, String names, String surNames, String email,
			AlmacenConvenioDto store) {
		super();
		this.id = id;
		this.codeEmploy = codeEmploy;
		this.names = names;
		this.surNames = surNames;
		this.email = email;
		this.store = store;
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


	public AlmacenConvenioDto getStore() {
		return store;
	}


	public void setStore(AlmacenConvenioDto store) {
		this.store = store;
	}
	
}
