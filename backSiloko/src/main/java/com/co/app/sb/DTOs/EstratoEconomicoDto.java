package com.co.app.sb.DTOs;

public class EstratoEconomicoDto {

	private int id;
	
	private int numClassEconomic;
	
	private int amountPoints;

	public EstratoEconomicoDto(int id, int numClassEconomic, int amountPoints) {
		super();
		this.id = id;
		this.numClassEconomic = numClassEconomic;
		this.amountPoints = amountPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumClassEconomic() {
		return numClassEconomic;
	}

	public void setNumClassEconomic(int numClassEconomic) {
		this.numClassEconomic = numClassEconomic;
	}

	public int getAmountPoints() {
		return amountPoints;
	}

	public void setAmountPoints(int amountPoints) {
		this.amountPoints = amountPoints;
	}
	
	
	
	
	
}
