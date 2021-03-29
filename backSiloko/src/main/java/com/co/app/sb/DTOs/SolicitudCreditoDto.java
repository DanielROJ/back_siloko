package com.co.app.sb.DTOs;

import java.sql.Date;

public class SolicitudCreditoDto {

	private long id;
	
	private String codeCredito;
	
	private Date dateRequest;
	
	private Date datefinalRequest;
	
	private int numFees;
	
	private int numFeesPaid;
	
	private Date dateLastPaid;
	
	private ClienteDto client;
	
	private ProductoCreditoDto product;
	
	private FuncionarioDto employManager;
	
	private FuncionarioAlmacenDto employStore;
	
	
	private EstadoCreditoDto status;

	public SolicitudCreditoDto(long id, String codeCredito, Date dateRequest, Date datefinalRequest, int numFees,
			int numFeesPaid, Date dateLastPaid, ClienteDto client, ProductoCreditoDto product,
			FuncionarioDto employManager, FuncionarioAlmacenDto employStore) {
		super();
		this.id = id;
		this.codeCredito = codeCredito;
		this.dateRequest = dateRequest;
		this.datefinalRequest = datefinalRequest;
		this.numFees = numFees;
		this.numFeesPaid = numFeesPaid;
		this.dateLastPaid = dateLastPaid;
		this.client = client;
		this.product = product;
		this.employManager = employManager;
		this.employStore = employStore;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeCredito() {
		return codeCredito;
	}

	public void setCodeCredito(String codeCredito) {
		this.codeCredito = codeCredito;
	}

	public Date getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Date getDatefinalRequest() {
		return datefinalRequest;
	}

	public void setDatefinalRequest(Date datefinalRequest) {
		this.datefinalRequest = datefinalRequest;
	}

	public int getNumFees() {
		return numFees;
	}

	public void setNumFees(int numFees) {
		this.numFees = numFees;
	}

	public int getNumFeesPaid() {
		return numFeesPaid;
	}

	public void setNumFeesPaid(int numFeesPaid) {
		this.numFeesPaid = numFeesPaid;
	}

	public Date getDateLastPaid() {
		return dateLastPaid;
	}

	public void setDateLastPaid(Date dateLastPaid) {
		this.dateLastPaid = dateLastPaid;
	}

	public ClienteDto getClient() {
		return client;
	}

	public void setClient(ClienteDto client) {
		this.client = client;
	}

	public ProductoCreditoDto getProduct() {
		return product;
	}

	public void setProduct(ProductoCreditoDto product) {
		this.product = product;
	}

	public FuncionarioDto getEmployManager() {
		return employManager;
	}

	public void setEmployManager(FuncionarioDto employManager) {
		this.employManager = employManager;
	}

	public FuncionarioAlmacenDto getEmployStore() {
		return employStore;
	}

	public void setEmployStore(FuncionarioAlmacenDto employStore) {
		this.employStore = employStore;
	}

	public EstadoCreditoDto getStatus() {
		return status;
	}

	public void setStatus(EstadoCreditoDto status) {
		this.status = status;
	}	
	
}
