package com.co.app.sb.DTOs;

import java.math.BigDecimal;
import java.sql.Date;

public class CupoCreditoDto {
	
	private long id;
	
	private BigDecimal totalSizeCredit;
	
	private BigDecimal sizeCreditUsed;
	
	private BigDecimal sizeTransactionCredit;
	
	private Date dateLastStudyCredit;

	private EstadoCupoDto statusCredit;
	
	

	public CupoCreditoDto(long id, BigDecimal totalSizeCredit, BigDecimal sizeCreditUsed,
			BigDecimal sizeTransactionCredit, Date dateLastStudyCredit, EstadoCupoDto statusCredit) {
		super();
		this.id = id;
		this.totalSizeCredit = totalSizeCredit;
		this.sizeCreditUsed = sizeCreditUsed;
		this.sizeTransactionCredit = sizeTransactionCredit;
		this.dateLastStudyCredit = dateLastStudyCredit;
		this.statusCredit = statusCredit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getTotalSizeCredit() {
		return totalSizeCredit;
	}

	public void setTotalSizeCredit(BigDecimal totalSizeCredit) {
		this.totalSizeCredit = totalSizeCredit;
	}

	public BigDecimal getSizeCreditUsed() {
		return sizeCreditUsed;
	}

	public void setSizeCreditUsed(BigDecimal sizeCreditUsed) {
		this.sizeCreditUsed = sizeCreditUsed;
	}

	public BigDecimal getSizeTransactionCredit() {
		return sizeTransactionCredit;
	}

	public void setSizeTransactionCredit(BigDecimal sizeTransactionCredit) {
		this.sizeTransactionCredit = sizeTransactionCredit;
	}

	public Date getDateLastStudyCredit() {
		return dateLastStudyCredit;
	}

	public void setDateLastStrudyCredit(Date dateLastStudyCredit) {
		this.dateLastStudyCredit = dateLastStudyCredit;
	}

	public EstadoCupoDto getStatusCredit() {
		return statusCredit;
	}

	public void setStatusCredit(EstadoCupoDto statusCredit) {
		this.statusCredit = statusCredit;
	}
	
	
	

}
