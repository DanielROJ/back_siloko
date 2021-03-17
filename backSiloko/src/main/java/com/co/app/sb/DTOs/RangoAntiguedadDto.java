package com.co.app.sb.DTOs;

public class RangoAntiguedadDto {
	
	private long id;
	
	private String rangeOld;
	
	private int amountPoints;

	public RangoAntiguedadDto(long id, String rangeOld, int amountPoints) {
		super();
		this.id = id;
		this.rangeOld = rangeOld;
		this.amountPoints = amountPoints;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRangeOld() {
		return rangeOld;
	}

	public void setRangeOld(String rangeOld) {
		this.rangeOld = rangeOld;
	}

	public int getAmountPoints() {
		return amountPoints;
	}

	public void setAmountPoints(int amountPoints) {
		this.amountPoints = amountPoints;
	}
	
	

}
