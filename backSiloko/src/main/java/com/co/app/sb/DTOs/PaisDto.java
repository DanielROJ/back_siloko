package com.co.app.sb.DTOs;

import java.math.BigDecimal;

public class PaisDto {

	private long id;
	
	private String name;
	
	private BigDecimal valuePoint;
	
	private String typeCoin;
	
	private int amountPoints;

	public PaisDto(long id, String name, BigDecimal valuePoint, String typeCoin, int amountPoints) {
		super();
		this.id = id;
		this.name = name;
		this.valuePoint = valuePoint;
		this.typeCoin = typeCoin;
		this.amountPoints = amountPoints;
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

	public BigDecimal getValuePoint() {
		return valuePoint;
	}

	public void setValuePoint(BigDecimal valuePoint) {
		this.valuePoint = valuePoint;
	}

	public String getTypeCoin() {
		return typeCoin;
	}

	public void setTypeCoin(String typeCoin) {
		this.typeCoin = typeCoin;
	}

	public int getamountPoints() {
		return amountPoints;
	}

	public void setamountPoints(int amountPoints) {
		this.amountPoints = amountPoints;
	}
	
	
}
