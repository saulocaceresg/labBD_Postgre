package model;

import java.math.BigDecimal;

public class Cargo {
	
	private int carid;
	private String carnom;
	private String cardes;
	private BigDecimal carsue;
	private String carestreg;

	public Cargo() {
	}
	
	public Cargo(int carid, String carnom, String cardes, BigDecimal carsue, String carestreg) {
		this.carid = carid;
		this.carnom = carnom;
		this.cardes = cardes;
		this.carsue = carsue;
		this.carestreg = carestreg;
	}

	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public String getCarnom() {
		return carnom;
	}

	public void setCarnom(String carnom) {
		this.carnom = carnom;
	}

	public String getCardes() {
		return cardes;
	}

	public void setCardes(String cardes) {
		this.cardes = cardes;
	}

	public BigDecimal getCarsue() {
		return carsue;
	}

	public void setCarsue(BigDecimal carsue) {
		this.carsue = carsue;
	}

	public String getCarestreg() {
		return carestreg;
	}

	public void setCarestreg(String carestreg) {
		this.carestreg = carestreg;
	}
	
	
	
}
